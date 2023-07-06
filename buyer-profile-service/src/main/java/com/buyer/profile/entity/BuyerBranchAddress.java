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
@Table(name = "BUYER_BRANCH_ADDRESS")
@Data
@ToString
public class BuyerBranchAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUBRAD_ID")
	private Long id;

	@Column(name = "BUBRAD_BUBR_ID")
	private Long branchId;

	@Column(name = "BUBRAD_ADDRESS_DETAILS")
	private String addressDetails;

	@Column(name = "BUBRAD_DISTINCT")
	private String distinct;

	@Column(name = "BUBRAD_SUB_DISTINCT")
	private String subDistinct;

	@Column(name = "BUBRAD_PROVINCE")
	private String province;

	@Column(name = "BUBRAD_POSTCODE")
	private String postcode;

	@Column(name = "BUBRAD_SELECT_FLAG")
	private String selectFlag;

	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "UPDATE_DATE")
	private LocalDateTime updateDate;

	@Column(name = "UPDATE_BY")
	private String updateBy;
}
