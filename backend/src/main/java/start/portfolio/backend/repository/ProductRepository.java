package start.portfolio.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import start.portfolio.backend.dto.ProductDto;
import start.portfolio.backend.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
	
	Optional<Product> findById(Long id);

}
