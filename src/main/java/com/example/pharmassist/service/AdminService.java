package com.example.pharmassist.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.pharmassist.entity.Admin;
import com.example.pharmassist.exception.AdminNotFoundByIdException;
import com.example.pharmassist.mapper.AdminMapper;
import com.example.pharmassist.repository.AdminRepository;
import com.example.pharmassist.requestdtos.AdminRequest;
import com.example.pharmassist.responsedtos.AdminResponse;
import com.example.pharmassist.util.AppResponseBuilder;

@Service
public class AdminService
{
	private final AdminRepository adminRepository;
	private final AdminMapper adminMapper;
	private final PasswordEncoder passwordEncoder;

	public AdminService(AdminRepository adminRepository,AdminMapper adminMapper,PasswordEncoder passwordEncoder)
	{
		this.adminRepository=adminRepository;
		this.adminMapper=adminMapper;
		this.passwordEncoder=passwordEncoder;
	}

	public AdminResponse addAdmin(AdminRequest adminRequest)
	{
		Admin admin=adminMapper.mapToAdmin(adminRequest, new Admin());
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		admin=adminRepository.save(admin);
		return adminMapper.mapToAdminResponse(admin);
	}

	public AdminResponse findAdmin(String adminId)
	{
		return adminRepository.findById(adminId)
				.map(adminMapper::mapToAdminResponse)
				.orElseThrow(() -> new AdminNotFoundByIdException("Failed to Find Admin"));
	}

	public AdminResponse updateAdmin(AdminRequest adminRequest,String adminId)
	{
		return adminRepository.findById(adminId)
				.map(exAdmin ->{
					adminMapper.mapToAdmin(adminRequest, exAdmin);
					return adminRepository.save(exAdmin);
				})
				.map(adminMapper::mapToAdminResponse)
				.orElseThrow(() -> new AdminNotFoundByIdException("Failed to update admin"));
	}

}
