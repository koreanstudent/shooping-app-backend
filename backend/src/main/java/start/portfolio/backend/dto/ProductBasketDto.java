package start.portfolio.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //기본생성자 필요
public class ProductBasketDto {

	private Long id;
	private int basketCount;
	private String productName;
	private int productPrice;
	private int productStockAmount;
	
	public ProductBasketDto( Long id,int basketCount,String productName, int productPrice, int productStockAmount) {
		this.id = id;
		this.basketCount = basketCount;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStockAmount = productStockAmount;
	
	}
}
