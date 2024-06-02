package Service;


import org.hibernate.Session;
import org.hibernate.Transaction;


import com.example.Questao1.Produto;

public class ProdutoService {
	
	Produto prudutoNovo = new Produto();
	
			
    
	@SuppressWarnings("deprecation")
	public void adicionarProduto(Produto produto) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Produto produtoLido = session.get(Produto.class, prudutoNovo.getId());
	    Transaction transaction = session.beginTransaction();
	    session.save(produtoLido);
	    transaction.commit();
	    session.close();
	}

}

