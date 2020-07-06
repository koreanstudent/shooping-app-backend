package start.portfolio.backend.repository;

import java.util.List;

import start.portfolio.backend.dto.ProductDto;
import start.portfolio.backend.dto.ProductListDto;
import start.portfolio.backend.entity.ProductBasket;


public interface ProductRepositoryCustom {

	List<ProductListDto> getMyProduct();
	 
	ProductDto findProductDetail(Long id);
	
	ProductBasket findProductBasket();
}
