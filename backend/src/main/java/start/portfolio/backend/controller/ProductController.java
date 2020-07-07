package start.portfolio.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import start.portfolio.backend.dto.ProductBasketDto;
import start.portfolio.backend.dto.ProductDto;
import start.portfolio.backend.dto.ProductListDto;
import start.portfolio.backend.service.ProductService;


@RestController
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;




	// 상품 상세
	@GetMapping("/product/{id}")
	public ProductDto productDetail(@PathVariable("id") Long productId) {
		ProductDto findProductDetail = productService.findById(productId); // 엔티티 -> DTO 변환 
		
		return findProductDetail;
	} 
	// 장바구니
	@GetMapping("/product/basket")
	public List<ProductBasketDto> productBasket() {
		List<ProductBasketDto> findProductDetail = productService.findProductBasket(); // 엔티티 -> DTO 변환 
		findProductDetail = findProductDetail.stream().map(m -> new ProductBasketDto(m.getId(),m.getBasketCount(),m.getProductName(),m.getProductPrice(),m.getProductStockAmount())).collect(Collectors.toList());
		
		return findProductDetail;
	} 
	

	
}
