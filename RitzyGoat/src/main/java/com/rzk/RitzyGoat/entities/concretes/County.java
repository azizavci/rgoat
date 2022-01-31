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
@Table(name = "counties")
public class County {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="county_name")
	private String countyName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "county")
	private List<Address> addresses;
	
	@JsonIgnore
	@OneToMany(mappedBy = "county")
	private List<Neighborhood> neighborhoods ;
	
	@JsonIgnore
	@OneToMany(mappedBy = "county")
	private List<Seller> sellers;
	
	
}
