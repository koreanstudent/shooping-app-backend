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
public class File {

	@Id @GeneratedValue
	@Column(name ="file_id")
	private Long id;
	
	private String fileName;
	private int fileSize;
	private String filePath;
	
	@OneToMany(mappedBy = "file")
	private List<BannerFile> bannerFile = new ArrayList<>();
	
	@OneToMany(mappedBy = "file")
	private List<ProductFile> productFile = new ArrayList<>();
	
	@OneToMany(mappedBy = "file")
	private List<CommentFile> commentFile = new ArrayList<>();

	public File(String fileName, int fileSize, String filePath) {
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.filePath = filePath;
	}
	
	
	
	
	
}
