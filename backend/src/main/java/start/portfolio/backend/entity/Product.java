package start.portfolio.backend.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name ="product_id")
	private Long id;
	
	private String productName;
	private int productPrice;
	private int productStockAmount;
	private String productHtmlContent;
	

	
	@OneToMany(mappedBy="product")
	private List<Banner> banner = new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
	private List<ProductFile> productFile = new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
	private List<ProductBasket> baskets =new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
	List<Comment> comments = new ArrayList<>();
	
	public Product(String productName, int productPrice ) {
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public Product(String productName, int productPrice,int productStockAmount,String productHtmlContent) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStockAmount = productStockAmount;
		this.productHtmlContent = productHtmlContent;
	}

	
	
	
	
	
	

}
