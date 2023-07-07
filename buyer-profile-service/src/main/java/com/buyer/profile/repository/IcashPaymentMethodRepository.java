package com.buyer.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyer.profile.entity.IcashPaymentMethod;

public interface IcashPaymentMethodRepository extends JpaRepository<IcashPaymentMethod, Long> {

}
