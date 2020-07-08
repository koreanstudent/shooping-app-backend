package start.portfolio.backend.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Banner {
	
	@Id
	@GeneratedValue
	@Column(name ="banner_id")
	private Long id;
	
	private String bannerName;
	private int bannerOrders;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="product_id")
	private Product product;
	
	@OneToMany(mappedBy = "banner")
	private List<BannerFile> bannerFile = new ArrayList<>();

	
	public Banner(String bannerName, int bannerOrders, Product product) {
		this.bannerName = bannerName;
		this.bannerOrders = bannerOrders;
		if(product != null) {
			ProductBanner(product);
		}
	}
	public void ProductBanner(Product product) {
		this.product = product;
		product.getBanner().add(this);
	}
	
	
	

}
