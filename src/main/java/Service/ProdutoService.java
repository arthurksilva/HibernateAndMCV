package Service;
import com.example.Questao1.Produto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import com.example.Questao1.Fornecedor;


public class ProdutoService {
	
	Produto prudutoNovo = new Produto();
	
	public void adicionarProduto(Produto produto) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Produto produtoLido = session.get(Produto.class, prudutoNovo.getId());
	    Transaction transaction = session.beginTransaction();
	    session.persist(produtoLido);
	    transaction.commit();
	    session.close();
	}

	public List<Produto> buscarProdutosPorCategoria(Long idCategoria) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Query<Produto> query = session.createQuery("FROM Produto WHERE categoria.id = :idCategoria", Produto.class);
	    query.setParameter("idCategoria", idCategoria);
	    List<Produto> produtos = query.getResultList();
	    session.close();
	    return produtos;
	}
	
	public List<Fornecedor> buscarFornecedoresPorProduto(Long idProduto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Fornecedor> query = session.createQuery("SELECT f FROM Produto p JOIN p.fornecedores f WHERE p.id = :idProduto", Fornecedor.class);
        query.setParameter("idProduto", idProduto);
        List<Fornecedor> fornecedores = query.getResultList();
        session.close();
        return fornecedores;
    }
}
