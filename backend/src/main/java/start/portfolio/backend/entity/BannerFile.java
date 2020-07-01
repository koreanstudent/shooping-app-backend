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
public class BannerFile {
	
	@Id @GeneratedValue
	@Column(name ="banner_file_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "banner_id")
	private Banner banner;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "file_id")
	private File file;

	public BannerFile(Banner banner, File file) {
		if(banner!=null || file != null) {
			setBanner(banner);
			setFile(file);
		}
	}
	
	public void setBanner(Banner banner) {
		this.banner = banner;
		banner.getBannerFile().add(this);
	}
	
	public void setFile(File file) {
		this.file = file;
		file.getBannerFile().add(this);
	}
	
	
	

}
