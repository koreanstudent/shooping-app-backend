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
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue
	@Column(name ="member_id")
	private Long id;
	
	
	private String memberName;
	private String memberPassword;
	private String memberPhone;
	private String memberEmail;
	
	@OneToMany(mappedBy = "member")
	List<ProductBasket> baskets = new ArrayList<>();
	
	@OneToMany(mappedBy = "member")
	List<Comment> comments = new ArrayList<>();

	public Member(String memberName) {
		this.memberName = memberName;
	}
	
	public Member( String memberName, String memberPassword, String memberPhone, String memberEmail) {
		this.memberName = memberName;
		this.memberPassword = memberPassword;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
	}
	
	public Member( String memberName, String memberPassword) {
		this.memberName = memberName;
		this.memberPassword = memberPassword;

	}
	
	
	
}
