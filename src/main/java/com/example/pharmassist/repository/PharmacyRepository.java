package com.example.pharmassist.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pharmassist.entity.Pharmacy;

public interface PharmacyRepository extends JpaRepository<Pharmacy,String>
{

}
