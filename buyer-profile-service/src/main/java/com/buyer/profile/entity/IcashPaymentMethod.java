package com.buyer.profile.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "BUYER_ICASH_PAYMENT_METHOD")
@Data
@ToString
public class IcashPaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUICPM_ID")
	private Long id;
	
	@Column(name = "BUICPM_BUCP_ID")
	private Long companyProfileId;
	
	@Column(name = "BUICPM_PRODUCT_CODE")
	private String productCode;
	
	@Column(name = "BUICPM_PRODUCT_DETAIL")
	private String productDetail;
	
	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;
	
	@Column(name = "CREATE_BY")
	private String createBy;
}
