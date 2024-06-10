package com.example.Questao1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Categoria categoria1 = new Categoria("Eletrônicos");
            Categoria categoria2 = new Categoria("Informática");

            Fornecedor fornecedor1 = new Fornecedor("Fornecedor A");
            Fornecedor fornecedor2 = new Fornecedor("Fornecedor B");

            Produto produto1 = new Produto("Smartphone", 1500.0);
            produto1.setCategoria(categoria1);
            produto1.getFornecedores().add(fornecedor1);
            produto1.getFornecedores().add(fornecedor2);

            Produto produto2 = new Produto("Notebook", 3000.0);
            produto2.setCategoria(categoria2);
            produto2.getFornecedores().add(fornecedor1);

            em.persist(categoria1);
            em.persist(categoria2);
            em.persist(fornecedor1);
            em.persist(fornecedor2);
            em.persist(produto1);
            em.persist(produto2);

            tx.commit();

            System.out.println("Produtos:");
            List<Produto> produtos = em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
            for (Produto produto : produtos) {
                System.out.println("Nome: " + produto.getNome() + ", Preço: " + produto.getPreco());
                System.out.println("Categoria: " + produto.getCategoria().getNome());
                System.out.println("Fornecedores:");
                for (Fornecedor fornecedor : produto.getFornecedores()) {
                    System.out.println(" - " + fornecedor.getNome());
                }
                System.out.println();
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
