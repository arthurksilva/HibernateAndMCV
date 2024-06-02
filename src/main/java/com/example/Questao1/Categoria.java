package com.example.Questao1;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nome;
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

		public Categoria() {
	    }

	    public Categoria(String nome) {
	        this.nome = nome;
	    }
	    
	    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Produto> produtos;
	    
		public List<Produto> getProdutos() {
			return produtos;
		}
		public void setProdutos(List<Produto> produtos) {
			this.produtos = produtos;
		}
}
