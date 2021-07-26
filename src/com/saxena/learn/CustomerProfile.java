package com.ejb.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUST_PROFILE")
public class CustomerProfile {

	@Id
	@Column(name = "PROFILE_ID")
	private Long profileId;

	@OneToOne
	@JoinColumn(name = "CUSTOMERID")
	private Customer customer;

}
