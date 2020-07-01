package start.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import start.portfolio.backend.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

}
