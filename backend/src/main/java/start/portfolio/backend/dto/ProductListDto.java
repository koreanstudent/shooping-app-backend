package start.portfolio.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //기본생성자 필요
public class ProductListDto {

	private String productName;
	private int productPrice;
	private String fileName;
	
	
	public ProductListDto(String productName, int productPrice, String fileName) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.fileName = fileName;
	}
	

}
