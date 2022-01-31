package com.rzk.RitzyGoat.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sellers")
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone")
	private String phone;

	@NotBlank
	@Size(max = 50)
	@Email
	@Column(name="email",unique = true)
	private String email;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "county_id")
	private County county;

	@ManyToOne()
	@JoinColumn(name = "neighborhood_id")
	private Neighborhood neighborhood;

	@Column(name = "open_address")
	private String openAddress;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	@Column(name="is_verified")
	private boolean isVerified;
	

}
