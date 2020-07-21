package start.portfolio.backend.entity;

import static start.portfolio.backend.entity.QFile.file;
import static start.portfolio.backend.entity.QProduct.product;
import static start.portfolio.backend.entity.QProductFile.productFile;

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

import start.portfolio.backend.dto.ProductDto;
import start.portfolio.backend.dto.ProductListDto;
import start.portfolio.backend.repository.ProductRepository;
@SpringBootTest
@Transactional
@Commit
class BannerTest {

@Autowired ProductRepository productRepositryTest;
	
	@Autowired
	EntityManager em;
	
	JPAQueryFactory queryFactory;
	
	@BeforeEach
	public void test() 
	
	{

		queryFactory = new JPAQueryFactory(em);
		Product product = new Product("이창현", 1000);
		Product product2 = new Product("이창현2", 2000);
		
		em.persist(product);
		em.persist(product2);
		
		Banner banner = new Banner("이창현", 1,product);
		Banner banner2 = new Banner("철수", 2,product2);
		
		em.persist(banner);
		em.persist(banner2);
		
		File file = new File("첫번째 파일 이름",100,"파일경로");
		
		File file2 = new File("두번째 파일 이름",2000,"파일경로2");
		
		File file3 = new File("세번째 파일 이름",4000,"파일경로5");
		
		em.persist(file);
		em.persist(file2);
		em.persist(file3);
		
		BannerFile bannerfile = new BannerFile(banner,file);
		BannerFile bannerfile2 = new BannerFile(banner2,file2);
		
	
		em.persist(bannerfile);
		em.persist(bannerfile2);
		
		ProductFile productFile = new ProductFile(product,file);
		ProductFile productFile1 = new ProductFile(product2,file);
		ProductFile productFile2 = new ProductFile(product2,file2);
		ProductFile productFile3 = new ProductFile(product2,file3);
		
		
		em.persist(productFile);
		em.persist(productFile1);
		em.persist(productFile2);
		em.persist(productFile3);
		
		
	}
	
	
	
	
	@Test
	public void Mainproduct() {
		
		List<ProductListDto> result = queryFactory
				.select(Projections.constructor(ProductListDto.class,
						product.productName,
						product.productPrice,
						file.fileName))
				.from(product,productFile, file)
				.where(product.id.eq(productFile.product.id).and(file.id.eq(productFile.file.id)))
				.fetch();
		
		for(ProductListDto productListDto : result ) {
			
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@" +productListDto );
		}


		
	}
}
