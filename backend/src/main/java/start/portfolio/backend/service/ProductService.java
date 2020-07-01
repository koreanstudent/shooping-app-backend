package start.portfolio.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import start.portfolio.backend.dto.BannerDto;
import start.portfolio.backend.dto.ProductListDto;
import start.portfolio.backend.repository.BannerRepository;
import start.portfolio.backend.repository.ProductRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	
	private final BannerRepository bannerRepository;

	@Transactional
	public List<BannerDto> findBanner() {
		return bannerRepository.getBanner();
	}
	
	@Transactional
	public List<ProductListDto> findproduct() {
		return productRepository.getMyProduct();
	}
}
