package start.portfolio.backend.repository;

import static start.portfolio.backend.entity.QFile.file;
import static start.portfolio.backend.entity.QProduct.product;
import static start.portfolio.backend.entity.QProductFile.productFile;

import java.util.List;

import javax.persistence.EntityManager;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import start.portfolio.backend.dto.ProductListDto;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

	private final JPAQueryFactory queryFactory;
	
	public ProductRepositoryImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	@Override
	public List<ProductListDto> getMyProduct() {
		
		return queryFactory
				.select(Projections.constructor(ProductListDto.class,
						product.productName,
						product.productPrice,
						file.fileName))
				.from(product,productFile, file)
				.where(product.id.eq(productFile.product.id).and(file.id.eq(productFile.file.id)))
				.fetch();
	}

}
