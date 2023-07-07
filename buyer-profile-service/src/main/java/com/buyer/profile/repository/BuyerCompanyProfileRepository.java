package com.buyer.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyer.profile.entity.BuyerCompanyProfile;

public interface BuyerCompanyProfileRepository extends JpaRepository<BuyerCompanyProfile, Long> {

}
