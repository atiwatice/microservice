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
@Table(name = "BUYER_DOCUMENT_PROCESS")
@Data
@ToString
public class DocumentProcess {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUDP_ID")
	private Long id;
	
	@Column(name = "BUDP_BUCP_ID")
	private Long companyProfileId;
	
	@Column(name = "BUDP_PROCESS_NAME")
	private String processName;
	
	@Column(name = "BUDP_PROCESS_DETAIL")
	private String processDetail;
	
	@Column(name = "BUDP_ACTIVE_STATUS")
	private String activeStatus;
	
	@Column(name = "CREATE_DATE")
	private LocalDateTime createDate;
	
	@Column(name = "CREATE_BY")
	private String createBy;
	
	@Column(name = "UPDATE_DATE")
	private LocalDateTime updateDate;
	
	@Column(name = "UPDATE_BY")
	private String updateBy;
}
