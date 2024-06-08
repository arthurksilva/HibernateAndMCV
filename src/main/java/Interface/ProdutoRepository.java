package Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Questao1.Produto;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoriaId(Long categoriaId);
}