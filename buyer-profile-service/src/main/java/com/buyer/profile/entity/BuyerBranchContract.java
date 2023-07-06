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
@Table(name = "BUYER_BRANCH_CONTRACT")
@Data
@ToString
public class BuyerBranchContract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUBC_ID")
	private Long id;

	@Column(name = "BUBC_BUBR_ID")
	private Long branchId;

	@Column(name = "BUBC_NAME")
	private String name;

	@Column(name = "BUBC_EMAIL")
	private String email;

	@Column(name = "BUBC_MOBILE_NO")
	private String mobileNo;

	@Column(name = "BUBC_OFFICE_NO")
	private String officeNo;

	@Column(name = "BUBC_FAX_NO")
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
