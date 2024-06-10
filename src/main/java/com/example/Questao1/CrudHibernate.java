package com.example.Questao1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import Service.HibernateUtil;

import java.util.Scanner;

public class CrudHibernate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Criar novo categoria
        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônicos");

        //Criar conexão com banco
        Session session = HibernateUtil.getSessionFactory()
               .openSession();
        Transaction transaction = session.beginTransaction();

        //Create
        session.persist(categoria);

        transaction.commit();
        session.close();

        scanner.nextLine();

        //Read
        session = HibernateUtil.getSessionFactory()
               .openSession();
        Categoria categoriaLida = session.get(Categoria.class, categoria.getId());
        System.out.println("Nome: " + categoriaLida.getNome());
        session.close();

        scanner.nextLine();

        //Criar novo produto
        Produto produto = new Produto();
        produto.setNome("Smartphone");
        produto.setPreco(1500.0);
        produto.setCategoria(categoriaLida);

        session = HibernateUtil.getSessionFactory()
               .openSession();
        transaction = session.beginTransaction();

        //Create
        session.persist(produto);
        transaction.commit();
        session.close();

        scanner.nextLine();

        //Read
        session = HibernateUtil.getSessionFactory()
               .openSession();
        Produto produtoLido = session.get(Produto.class, produto.getId());
        System.out.println("Nome: " + produtoLido.getNome() + ", Preço: " + produtoLido.getPreco());
        System.out.println("Categoria: " + produtoLido.getCategoria().getNome());
        session.close();

        scanner.nextLine();

        //Criar novo fornecedor
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome("Fornecedor A");

        session = HibernateUtil.getSessionFactory()
               .openSession();
        transaction = session.beginTransaction();

        //Create
        session.persist(fornecedor);
        transaction.commit();
        session.close();

        scanner.nextLine();

        //Read
        session = HibernateUtil.getSessionFactory()
               .openSession();
        Fornecedor fornecedorLido = session.get(Fornecedor.class, fornecedor.getId());
        System.out.println("Nome: " + fornecedorLido.getNome());
        session.close();

        scanner.nextLine();

        //Associar produto com fornecedor
        produtoLido.getFornecedores().add(fornecedorLido);

        session = HibernateUtil.getSessionFactory()
                     .openSession();
        transaction = session.beginTransaction();

        // Update
        session.merge(produtoLido);
        transaction.commit();
        session.close();

     // Delete
        session = HibernateUtil.getSessionFactory()
                     .openSession();
        transaction = session.beginTransaction();
        session.remove(produtoLido);
        transaction.commit();
        session.close();
        
     // Fechar o objeto Scanner
        scanner.close();

        //Fechando as conexões
        HibernateUtil.shutdown();
    }
}