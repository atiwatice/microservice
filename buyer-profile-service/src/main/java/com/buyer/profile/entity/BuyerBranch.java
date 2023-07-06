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
@Table(name = "BUYER_BRANCH")
@Data
@ToString
public class BuyerBranch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUBR_ID")
	private Long id;

	@Column(name = "BUBR_BUCP_ID")
	private Long companyProfileId;

	@Column(name = "BUBR_VAT_BRANCH_CODE")
	private String vatBranchCode;

	@Column(name = "BUBR_VAT_BRANCH_NAME")
	private String vatBranchName;

	@Column(name = "BUBR_OBJECT_CODE1")
	private String objectCode1;

	@Column(name = "BUBR_OBJECT_NAME1")
	private String objectName1;

	@Column(name = "BUBR_OBJECT_CODE2")
	private String objectCode2;

	@Column(name = "BUBR_OBJECT_NAME2")
	private String objectName2;

	@Column(name = "BUBR_OBJECT_CODE3")
	private String objectCode3;

	@Column(name = "BUBR_OBJECT_NAME3")
	private String objectName3;

	@Column(name = "BUBR_OBJECT_CODE4")
	private String objectCode4;

	@Column(name = "BUBR_OBJECT_NAME4")
	private String objectName4;

	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "UPDATE_DATE")
	private LocalDateTime updateDate;

	@Column(name = "UPDATE_BY")
	private String updateBy;
}
