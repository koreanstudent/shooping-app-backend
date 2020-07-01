package start.portfolio.backend.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import start.portfolio.backend.dto.BannerDto;
import start.portfolio.backend.dto.ProductListDto;
import start.portfolio.backend.entity.Banner;
import start.portfolio.backend.service.ProductService;


@RestController
@RequiredArgsConstructor
public class MainController {
	
	private final ProductService productService;

	@GetMapping("/api/hello")
	public String hello() {
		return "현재 서버시간은  ??" + new Date();
	}
	 
	@GetMapping({"/", "/error"})
	public String index() {
		return "index.html";
	}
	  
	@GetMapping("/banner")
	public List<BannerDto> searchBanner() {
		List<BannerDto> findBanners = productService.findBanner(); // 엔티티 -> DTO 변환 
		findBanners = findBanners.stream().map(m -> new BannerDto(m.getBannerName(),m.getBannerOrders(),m.getFileName())).collect(Collectors.toList());
		
		return findBanners;
	} 
	
	@GetMapping("/product/recommend")
	public List<ProductListDto> searchRecommendProduct() {
		List<ProductListDto> findProducts = productService.findproduct(); // 엔티티 -> DTO 변환 
		findProducts = findProducts.stream().map(m -> new ProductListDto(m.getProductName(),m.getProductPrice(),m.getFileName())).collect(Collectors.toList());
		
		return findProducts;
	} 
	

	
}
