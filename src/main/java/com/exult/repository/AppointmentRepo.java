package com.exult.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.exult.dto.AppointmentDTO;
import com.exult.entity.Appointment;
import com.exult.exception.ExappException;

public interface AppointmentRepo extends CrudRepository<Appointment, Integer> {

//	Optional<List<Appointment>> findByPatient(Integer patientId)throws ExappException;
//
//	Optional<List<Appointment>> findByDoctor(Integer doctorId)throws ExappException;

}
