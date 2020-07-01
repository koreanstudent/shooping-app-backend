package start.portfolio.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import start.portfolio.backend.dto.ProductDto;
import start.portfolio.backend.dto.ProductListDto;
import start.portfolio.backend.entity.Product;


public interface ProductRepositoryCustom {

	List<ProductListDto> getMyProduct();
}
