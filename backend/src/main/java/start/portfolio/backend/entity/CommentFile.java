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

@Entity
@Getter 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentFile {
	
	@Id @GeneratedValue
	@Column(name ="comment_file_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comment_id")
	private Comment comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "file_id")
	private File file;

	public CommentFile(Comment comment, File file) {
		if(comment!=null || file != null) {
			setComment(comment);
			setFile(file);
		}
	}
	
	public void setComment(Comment comment) {
		this.comment = comment;
		comment.getCommentFile().add(this);
	}
	
	public void setFile(File file) {
		this.file = file;
		file.getCommentFile().add(this);
	}
	
	
	

}
