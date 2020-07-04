package start.portfolio.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import start.portfolio.backend.dto.ProductDto;
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
	

	
}
