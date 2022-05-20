package com.exult.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.exult.entity.Admin;

public interface AdminRepo extends CrudRepository<Admin, Integer> {

	public Optional<Admin> findByContactNumber(String contactNumber);

	public Admin findByEmailId(String emailId);
}
