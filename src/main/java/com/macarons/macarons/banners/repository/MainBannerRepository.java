package com.macarons.macarons.banners.repository;

import com.macarons.macarons.banners.entity.banners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainBannerRepository extends JpaRepository<banners, String>{

	List<banners> findByDltYnContaining(String dltYn);
	List<banners> findByBannerTypeContainingAndBannerLocationContainingAndDltYn(String bannerType, String bannerLocation, String dltYn);
}
