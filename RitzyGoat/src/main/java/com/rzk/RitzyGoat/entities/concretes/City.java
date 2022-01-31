package com.rzk.RitzyGoat.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="city_name")
	private String cityName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "city")
	private List<Address> addresses;
	
	@JsonIgnore
	@OneToMany(mappedBy = "city")
	private List<Seller> sellers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "city")
	private List<County> counties;
	
}