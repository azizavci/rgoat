package com.rzk.RitzyGoat.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rzk.RitzyGoat.entities.concretes.RGPayment;

public interface RgPaymentDao extends JpaRepository<RGPayment, Integer>{

}
