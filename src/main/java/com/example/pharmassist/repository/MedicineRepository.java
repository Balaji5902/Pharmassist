package com.example.pharmassist.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pharmassist.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine,String>
{

}
