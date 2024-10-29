package com.example.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmassist.requestdtos.AdminRequest;
import com.example.pharmassist.responsedtos.AdminResponse;
import com.example.pharmassist.service.AdminService;
import com.example.pharmassist.util.AppResponseBuilder;
import com.example.pharmassist.util.ErrorStructure;
import com.example.pharmassist.util.ResponseStructure;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AdminController 
{

	private final AdminService adminService;
	private final AppResponseBuilder appResponseBuilder;

	public AdminController(AdminService adminService,AppResponseBuilder appResponseBuilder)
	{
		this.adminService=adminService;
		this.appResponseBuilder=appResponseBuilder;
	}

	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> addAdmin(@RequestBody @Valid AdminRequest adminRequest)
	{
		AdminResponse response=adminService.addAdmin(adminRequest);
		return appResponseBuilder.success(HttpStatus.CREATED,"Admin Created", response);
	}

	@Operation(description = "The endpoint can be used to find the user based on the unique ID",
			responses = {
					@ApiResponse(responseCode = "302",description = "User Found"),
					@ApiResponse(responseCode = "404",description = "User not found by ID",
					content = {
							@Content(schema = @Schema(implementation = ErrorStructure.class))
					})
	})
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> findUser(@PathVariable String adminId)
	{
		AdminResponse adminResponse=adminService.findAdmin(adminId);
		return appResponseBuilder.success(HttpStatus.FOUND,"User is found",adminResponse);
	}


}
