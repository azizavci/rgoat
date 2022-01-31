package com.rzk.RitzyGoat.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

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

	@ManyToOne()
	@JoinColumn(name = "type_of_address_id")
	private TypeOfAddress typeOfAddress;

	@Column(name = "post_code")
	private String postCode;

	@Column(name = "address_name")
	private String addressName;

	@JsonIgnore
	@OneToMany(mappedBy = "address")
	private List<Order> orders;

}
