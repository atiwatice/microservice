package com.buyer.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyer.profile.entity.BuyerBranchActionHistory;

public interface BuyerBranchActionHistoryRepository extends JpaRepository<BuyerBranchActionHistory, Long> {

}
