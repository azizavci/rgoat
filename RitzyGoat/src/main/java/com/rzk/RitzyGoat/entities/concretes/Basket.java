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
@Table(name = "baskets")
public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="product_id")
	private Product product;

	@Column(name = "number_of_product")
	private int numberOfProduct;

	@Column(name = "order_amount")
	private float orderAmount;
	
	@Column(name="total_tax")
	private float totalTax;
	
	@Column(name="discount_rate")
	private int discountRate;
	
	@Column(name="total_price")
	private float totalPrice;

	@JsonIgnore
	@OneToMany(mappedBy = "basket")
	private List<OrderDetail> orderDetails;

}
