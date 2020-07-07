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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="member_id")
	private Member member;
	
	
	
	public ProductBasket(int basketCount, Product product, Member member ) {
		this.basketCount=basketCount;
		if(product != null || member != null) {
			setProductBasket(product, member);
		}
	}
	
	public void setProductBasket(Product product, Member member) {
		this.product = product;
		this.member = member;
		product.getBaskets().add(this);
		member.getBaskets().add(this);
	}

	
	
}
