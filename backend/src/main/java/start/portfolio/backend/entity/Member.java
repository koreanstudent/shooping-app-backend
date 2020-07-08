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
public class Member {

	@Id
	@GeneratedValue
	@Column(name ="member_id")
	private Long id;
	
	private String memberName;
	private int memberPassword;
	private int memberPhone;
	private String memberEmail;
	
	@OneToMany(mappedBy = "member")
	List<ProductBasket> baskets = new ArrayList<>();
	
	@OneToMany(mappedBy = "member")
	List<Comment> comments = new ArrayList<>();

	public Member( String memberName, int memberPassword, int memberPhone, String memberEmail) {
		this.memberName = memberName;
		this.memberPassword = memberPassword;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
	}
	
	
	
}
