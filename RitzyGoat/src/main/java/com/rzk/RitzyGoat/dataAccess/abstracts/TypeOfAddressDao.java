package com.rzk.RitzyGoat.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rzk.RitzyGoat.entities.concretes.TypeOfAddress;

public interface TypeOfAddressDao extends JpaRepository<TypeOfAddress, Integer> {

}
