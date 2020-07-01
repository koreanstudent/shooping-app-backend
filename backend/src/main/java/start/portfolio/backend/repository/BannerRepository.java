package start.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import start.portfolio.backend.entity.Banner;

public interface BannerRepository extends JpaRepository<Banner, Long>, BannerRepositoryCustom {

}
