package start.portfolio.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //기본생성자 필요
public class ProductDto {

	private Long id;
	private String productName;
	private int productPrice;
	private int productStockAmount;
	private String productHtmlContent;
	public ProductDto(Long id, String productName, int productPrice, int productStockAmount, String productHtmlContent
			) {
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStockAmount = productStockAmount;
		this.productHtmlContent = productHtmlContent;
	
	}
	
	
	

}
