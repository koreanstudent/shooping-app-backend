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
	private String fileName;

	
	public ProductDto(Long id, String productName, int productPrice, int productStockAmount, String productHtmlContent,String fileName ) {
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStockAmount = productStockAmount;
		this.productHtmlContent = productHtmlContent;
	
		this.fileName = fileName;
		
	}
	
	
	

}
