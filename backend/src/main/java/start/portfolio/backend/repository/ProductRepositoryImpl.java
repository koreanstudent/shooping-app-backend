package start.portfolio.backend.repository;

import static start.portfolio.backend.entity.QFile.file;
import static start.portfolio.backend.entity.QMember.member;
import static start.portfolio.backend.entity.QProduct.product;
import static start.portfolio.backend.entity.QProductBasket.productBasket;
import static start.portfolio.backend.entity.QProductFile.productFile;

import java.util.List;

import javax.persistence.EntityManager;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.support.QOracle10gDialect;

import start.portfolio.backend.dto.ProductBasketDto;
import start.portfolio.backend.dto.ProductDto;
import start.portfolio.backend.dto.ProductListDto;
import start.portfolio.backend.entity.ProductBasket;

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
 
	@Override
	public ProductDto getProductDetail(Long id) {
		
		BooleanBuilder builder = new BooleanBuilder();
		if(id != null) {
			builder.and(product.id.eq(id));
		}
		return queryFactory
				.select(Projections.fields(ProductDto.class,
						product.id,
						product.productName,
						product.productPrice,
						product.productHtmlContent,
						product.productStockAmount))
				.from(product)
				.where(builder)
				.fetchOne();
	}

	@Override
	public List<ProductBasketDto> getProductBasket() {
		
		return queryFactory
				.select(Projections.constructor(ProductBasketDto.class,
						productBasket.id,
						productBasket.basketCount,
						product.productName,
						product.productPrice,
						product.productStockAmount))
				.from(productBasket,product,member)
				.where(product.id.eq(productBasket.product.id).and(member.id.eq(productBasket.member.id)))
				.fetch(); 
	}

}
