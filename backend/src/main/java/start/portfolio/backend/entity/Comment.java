package start.portfolio.backend.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
@Getter
public class Comment {

	@Id
	@GeneratedValue
	@Column(name ="comment_id")
	private Long id;
	
	private String commentContent;
	private int raiting;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="member_id")
	private Member member;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="product_id")
	private Product product;
	
	@OneToMany(mappedBy = "comment")
	private List<CommentFile> commentFile = new ArrayList<>();
	
	public Comment(String commentContent, int raiting, Member member, Product product ) {
		this.commentContent =commentContent;
		this.raiting =raiting;
		
		if(product != null || member != null) {
			setComment(product, member);
		}
		
	}
	
	public void setComment(Product product, Member member) {
		this.product = product;
		this.member = member;
		product.getComments().add(this);
		member.getComments().add(this);
	}
	
}
