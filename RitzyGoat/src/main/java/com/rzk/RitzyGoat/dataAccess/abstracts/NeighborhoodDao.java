package com.rzk.RitzyGoat.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rzk.RitzyGoat.entities.concretes.Neighborhood;

public interface NeighborhoodDao extends JpaRepository<Neighborhood, Integer>{

}
