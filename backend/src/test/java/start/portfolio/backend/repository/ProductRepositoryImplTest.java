package start.portfolio.backend.repository;

import static start.portfolio.backend.entity.QProduct.product;
import static start.portfolio.backend.entity.QProductBasket.productBasket;
import static start.portfolio.backend.entity.QMember.member;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import start.portfolio.backend.dto.ProductBasketDto;
import start.portfolio.backend.entity.Member;
import start.portfolio.backend.entity.Product;
import start.portfolio.backend.entity.ProductBasket;

@SpringBootTest
@Transactional // 테스트 에서는 기본적으로 롤백 시킴
@Commit
class ProductRepositoryImplTest {
	@Autowired ProductRepository productRepositryTest;
	
	@Autowired
	EntityManager em;
	
	JPAQueryFactory queryFactory;
	
	@BeforeEach
	public void test() {

		queryFactory = new JPAQueryFactory(em);
		Member member = new Member("이창현", 11, 01066722131, "hn12344@naver.com");
				
		em.persist(member);
		Product product = new Product("상품1", 1000,100,"내용1");
		Product product2 = new Product("상품2", 2000,100,"내용2");
		
		em.persist(product);
		em.persist(product2);
//		
		
		ProductBasket productBasket = new ProductBasket(100,product,member);
		ProductBasket productBasket2 = new ProductBasket(200,product2,member);
		
		
		em.persist(productBasket);
		em.persist(productBasket2);
	}
	
	@Test
	public void ProductBsket() {
		List<ProductBasketDto> result = queryFactory
				.select(Projections.constructor(ProductBasketDto.class,
						productBasket.id,
						productBasket.basketCount,
						product.productName,
						product.productPrice,
						product.productStockAmount))
				.from(productBasket,product,member)
				.where(product.id.eq(productBasket.id).and(member.id.eq(productBasket.id)))
				.fetch();
		
		for (ProductBasketDto product : result) {
			System.out.println("tuple" + product);
		}
	}
}
