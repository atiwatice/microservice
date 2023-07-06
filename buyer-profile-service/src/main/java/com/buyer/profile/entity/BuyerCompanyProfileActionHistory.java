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
@Table(name = "BUYER_COMPANY_PROFILE_ACTION_HISTORY")
@Data
@ToString
public class BuyerCompanyProfileActionHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUCPAH_ID")
	private Long id;
	
	@Column(name = "BUCPAH_BUCP_ID")
	private Long companyProfileId;
	
	@Column(name = "BUCPAH_ACTION_DETAIL")
	private String actionDetail;
	
	@Column(name = "BUCPAH_ACTION")
	private String action;
	
	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;
	
	@Column(name = "CREATE_BY")
	private String createBy;
	
}
