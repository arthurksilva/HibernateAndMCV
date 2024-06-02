package com.example.Questao1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

	    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)	
		private Long id;
	    private String nome;
	    private double preco;
	    

	    @ManyToOne
	    @JoinColumn(name = "categoria_id")
	    private Categoria categoria;
	    
	    public Categoria getCategoria() {
			return categoria;
		}
		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public double getPreco() {
			return preco;
		}
		public void setPreco(double preco) {
			this.preco = preco;
		}
		
		 public Produto() {
		    }
		 public Produto(String nome, double preco) {
		        this.nome = nome;
		        this.preco = preco;
		    }

}
