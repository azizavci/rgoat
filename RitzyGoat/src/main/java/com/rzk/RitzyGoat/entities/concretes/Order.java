package com.rzk.RitzyGoat.entities.concretes;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne()
	@JoinColumn(name="shipper_id")
	private Shipper shipper;
	
	@ManyToOne()
	@JoinColumn(name="address_id")
	private Address address;
	
	@ManyToOne()
	@JoinColumn(name="payment_id")
	private RGPayment rgPayment;
	
	@Column(name="order_date")
	private LocalDateTime orderDate = LocalDateTime.now();
	
	@Column(name="ship_date")
	private Date shipDate;
	
	@Column(name="required_date")
	private Date requiredDate;
	
	@Column(name="payment_date")
	private Date paymentDate;
	
	@Column(name="transact_status")
	private String transactStatus;
	
	@Column(name="fulfilled")
	private Boolean fulfilled;
	
	@Column(name="is_cancelled")
	private Boolean isCancelled;
	
	@Column(name="is_paid")
	private Boolean isPaid;
	
	
	
}
