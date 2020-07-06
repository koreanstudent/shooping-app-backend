package start.portfolio.backend.repository;

import static start.portfolio.backend.entity.QProductBasket.productBasket;

import java.util.List;

import static start.portfolio.backend.entity.QProduct.product;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

import start.portfolio.backend.entity.Product;
import start.portfolio.backend.entity.ProductBasket;

@SpringBootTest
@Transactional
@Commit
public class ProductRepositoryImplTest {

	@Autowired ProductRepository productRepositryTest;
	
	@Autowired
	EntityManager em;
	
	JPAQueryFactory queryFactory;
	
	@BeforeEach
	public void test() 
	
	{

		queryFactory = new JPAQueryFactory(em);
		Product product = new Product("이창현", 1000,100,"내용1");
		Product product2 = new Product("이창현2", 2000,100,"내용2");
		
		em.persist(product);
		em.persist(product2);
//		
		
		ProductBasket productBasket = new ProductBasket(100,product);
		ProductBasket productBasket2 = new ProductBasket(200,product2);
		
		
		em.persist(productBasket);
		em.persist(productBasket2);
	}
	
	@Test
	public void ProductBsket() {
		List<ProductBasket> result = queryFactory
				.selectFrom(productBasket)
				.fetch();
		
		for (ProductBasket product : result) {
			System.out.println("tuple" + product);
		}
	}
}
