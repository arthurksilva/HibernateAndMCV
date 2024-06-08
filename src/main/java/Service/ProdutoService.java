package Service;
import com.example.Questao1.Produto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

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

	public List<Produto> buscarProdutosPorCategoria(Long idCategoria) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Query<Produto> query = session.createQuery("FROM Produto WHERE categoria.id = :idCategoria", Produto.class);
	    query.setParameter("idCategoria", idCategoria);
	    List<Produto> produtos = query.getResultList();
	    session.close();
	    return produtos;
	}
}
