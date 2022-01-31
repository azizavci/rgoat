package com.rzk.RitzyGoat.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rzk.RitzyGoat.entities.concretes.Shipper;

public interface ShipperDao extends JpaRepository<Shipper, Integer> {

}
