package start.portfolio.backend.repository;

import static start.portfolio.backend.entity.QBanner.banner;
import static start.portfolio.backend.entity.QBannerFile.bannerFile;
import static start.portfolio.backend.entity.QFile.file;

import java.util.List;

import javax.persistence.EntityManager;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import start.portfolio.backend.dto.BannerDto;

public class BannerRepositoryImpl implements BannerRepositoryCustom  {

	
	private final JPAQueryFactory queryFactory;
	
	public BannerRepositoryImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	@Override
	public List<BannerDto> getBanner() {
		return queryFactory
				.select(Projections.bean(BannerDto.class,
						banner.bannerName,
						banner.bannerOrders,
						file.fileName))
				.from(banner,bannerFile, file)
				.where(banner.id.eq(bannerFile.banner.id).and(file.id.eq(bannerFile.file.id)))
				.fetch();
		
	}
}
