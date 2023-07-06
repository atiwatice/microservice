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
@Table(name = "BUYER_COMPANY_PROFILE")
@Data
@ToString
public class BuyerCompanyProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUCP_ID")
	private Long id;
	
	@Column(name = "BUCP_COMPANY_CODE")
	private String companyCode;
	
	@Column(name = "BUCP_COMPANY_NAME_EN")
	private String companyNameEn;
	
	@Column(name = "BUCP_COMPANY_NAME_TH")
	private String companyNameTh;
	
	@Column(name = "BUCP_TAX_ID")
	private String taxId;
	
	@Column(name = "BUCP_ICASH_COMP_CODE")
	private String icashCompCode;
	
	@Column(name = "BUCP_PICTURE")
	private Byte picture;
	
	@Column(name = "BUCP_TWO_FACTOR_FLAG")
	private String twoFactorFlag;
	
	@Column(name = "BUCP_COMPANY_ADDRESS")
	private String companyAddress;
	
	@Column(name = "BUCP_COMPANY_DISTINCT")
	private String companyDistinct;
	
	@Column(name = "BUCP_COMPANY_SUB_DISTINCT")
	private String companySubDistinct;
	
	@Column(name = "BUCP_COMPANY_PROVINCE")
	private String companyProvince;
	
	@Column(name = "BUCP_POSTCODE")
	private String companyPostCode;
	
	@Column(name = "BUCP_ACTIVE_FLAG")
	private String activeFlag;
	
	@Column(name = "BUCP_STATUS")
	private String status;
	
	@Column(name = "BUCP_HASH")
	private String hash;
	
	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;
	
	@Column(name = "CREATE_BY")
	private String createBy;
	
	@Column(name = "UPDATE_DATE")
	private LocalDateTime updateDate;
	
	@Column(name = "UPDATE_BY")
	private String updateBy;
}
