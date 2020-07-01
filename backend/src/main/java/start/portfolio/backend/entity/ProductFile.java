package start.portfolio.backend.entity;

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
public class ProductFile {
	
	@Id @GeneratedValue
	@Column(name ="product_file_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "file_id")
	private File file;

	public ProductFile(Product product, File file) {
		if(product!=null || file != null) {
			setProduct(product);
			setFile(file);
		}
	}
	
	public void setProduct(Product product) {
		this.product = product;
		product.getProductFile().add(this);
	}
	
	public void setFile(File file) {
		this.file = file;
		file.getProductFile().add(this);
	}
	
	
	

}
