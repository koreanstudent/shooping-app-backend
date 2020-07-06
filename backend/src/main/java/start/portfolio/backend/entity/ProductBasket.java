package start.portfolio.backend.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductBasket {

	@Id
	@GeneratedValue
	@Column(name ="basket_id")
	private Long id;
	
	private int basketCount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;
	
	public ProductBasket(int basketCount, Product product ) {
		this.basketCount=basketCount;
		if(product != null) {
			setProductBasket(product);
		}
	}
	
	public void setProductBasket(Product product) {
		this.product = product;
		product.getBaskets().add(this);
	}
	
	
}
