package com.rzk.RitzyGoat.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rzk.RitzyGoat.entities.concretes.Order;

public interface OrderDao extends JpaRepository<Order,Integer> {

}
