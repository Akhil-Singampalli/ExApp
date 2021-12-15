package com.exult.service;

import java.util.List;

import com.exult.entity.Doctors;
import com.exult.exception.ExappException;

public interface DoctorsService {

	public List<Doctors> docDetails()throws ExappException;
}
