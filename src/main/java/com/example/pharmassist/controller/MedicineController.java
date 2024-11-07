package com.example.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.pharmassist.service.MedcineService;
import com.example.pharmassist.util.AppResponseBuilder;
import com.example.pharmassist.util.SimpleResponseStructure;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MedicineController 
{	
	private final AppResponseBuilder appResponseBuilder;
	private final MedcineService medcineService;

	public MedicineController(AppResponseBuilder appResponseBuilder,MedcineService medcineService) 
	{
		super();
		this.appResponseBuilder = appResponseBuilder;
		this.medcineService = medcineService;
	}

	@PostMapping("/pharmacies/{pharmacyId}/medicines")
	public ResponseEntity<SimpleResponseStructure> uploadMedicine(@RequestParam("medicine_info") MultipartFile file,@PathVariable String pharmacyId)
	{
		String message=medcineService.uploadMedicines(file,pharmacyId);
		return appResponseBuilder.success(HttpStatus.CREATED,message);
	}



}
