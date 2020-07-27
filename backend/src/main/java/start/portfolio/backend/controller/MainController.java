package start.portfolio.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import start.portfolio.backend.dto.BannerDto;
import start.portfolio.backend.dto.ProductListDto;
import start.portfolio.backend.service.ProductService;


@RestController
@RequiredArgsConstructor
public class MainController {
	
	private final ProductService productService;

	// 배너  
	@GetMapping("/banner")
	public List<BannerDto> searchBanner() {
		List<BannerDto> findBanners = productService.findBanner(); // 엔티티 -> DTO 변환 
		findBanners = findBanners.stream().map(m -> new BannerDto(m.getBannerName(),m.getBannerOrders(),m.getFileName())).collect(Collectors.toList());
		
		return findBanners;
	} 
	// 상품 추천
	@GetMapping("/product/recommend")
	public List<ProductListDto> searchRecommendProduct() {
		List<ProductListDto> findProducts = productService.findproduct(); // 엔티티 -> DTO 변환 
		findProducts = findProducts.stream().map(m -> new ProductListDto(m.getProductName(),m.getProductPrice(),m.getFileName())).collect(Collectors.toList());
		
		return findProducts;
	} 
	

	
}
