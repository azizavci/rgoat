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
@Table(name = "neighborhoods")
public class Neighborhood {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="county_id")
	private County county;
	
	@Column(name="neighborhood_name")
	private String neighborhoodName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "neighborhood")
	private List<Address> addresses;
	
	@JsonIgnore
	@OneToMany(mappedBy = "neighborhood")
	private List<Seller> sellers;
	
}
