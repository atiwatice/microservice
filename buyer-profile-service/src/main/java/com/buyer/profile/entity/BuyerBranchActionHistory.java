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
@Table(name = "BUYER_BRANCH_ACTION_HISTORY")
@Data
@ToString
public class BuyerBranchActionHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUBRAH_ID")
	private Long id;

	@Column(name = "BUBRAH_BUBR_ID")
	private Long branchId;
	
	@Column(name = "BUBRAH_ACTION_DETAIL")
	private String actionDetail;
	
	@Column(name = "BUBRAH_ACTION")
	private String action;
	
	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;

	@Column(name = "CREATE_BY")
	private String createBy;
}
