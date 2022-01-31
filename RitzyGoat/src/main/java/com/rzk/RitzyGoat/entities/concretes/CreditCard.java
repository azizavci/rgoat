package com.rzk.RitzyGoat.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credit_cards")
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "card_holder_name")
    private String cardHolderName;
	
	@Column(name = "card_number")
    private String cardNumber;
	
	@Column(name = "expire_year")
    private String expireYear;
	
	@Column(name = "expire_month")
    private String expireMonth;
	
	@Column(name = "cvc")
    private String cvc;
	
	@Column(name = "register_card")
    private Integer registerCard;
    	
}
