package com.exult.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exult.entity.Appointment;
import com.exult.exception.ExappException;
@Repository
@Transactional
public interface AppointmentRepo extends CrudRepository<Appointment, Integer> {

	@Query("SELECT apt FROM Appointment apt WHERE apt.PatientId =(:patientId) ")
	Optional<List<Appointment>> findByPatientid(Integer patientId)throws ExappException;

	@Query("SELECT apt FROM Appointment apt WHERE apt.DoctorId =(:doctorId) ")
	Optional<List<Appointment>> findByDoctorid(Integer doctorId)throws ExappException;
	


}
