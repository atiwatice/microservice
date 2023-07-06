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
@Table(name = "BUYER_BRANCH_ACCOUNT_INFO")
@Data
@ToString
public class BuyerBranchAccountInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUBA_ID")
	private Long id;

	@Column(name = "BUBA_BUBR_ID")
	private Long branchId;
	
	@Column(name = "BUBA_ACCOUNT_NO")
	private String accountNo;
	
	@Column(name = "BUBA_ACCOUNT_NAME")
	private String accountName;
	
	@Column(name = "BUBA_DEFAULT")
	private String defaultFlag;
	
	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "UPDATE_DATE")
	private LocalDateTime updateDate;

	@Column(name = "UPDATE_BY")
	private String updateBy;
}
