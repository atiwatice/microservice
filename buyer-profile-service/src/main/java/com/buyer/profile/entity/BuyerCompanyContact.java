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
@Table(name = "BUYER_COMPANY_CONTRACT")
@Data
@ToString
public class BuyerCompanyContact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUCT_ID")
	private Long id;

	@Column(name = "BUCT_BUCP_ID")
	private Long companyProfileId;

	@Column(name = "BUCT_NAME")
	private String name;

	@Column(name = "BUCT_EMAIL")
	private String email;

	@Column(name = "BUCT_MOBILE_NO")
	private String mobileNo;

	@Column(name = "BUCT_OFFICE_NO")
	private String officeNo;

	@Column(name = "BUCT_FAX_NO")
	private String faxNo;

	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "UPDATE_DATE")
	private LocalDateTime updateDate;

	@Column(name = "UPDATE_BY")
	private String updateBy;
}
