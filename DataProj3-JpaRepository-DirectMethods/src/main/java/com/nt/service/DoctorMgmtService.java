package com.nt.service;

import java.util.List;

import com.nt.dto.DoctorDTO;
public interface DoctorMgmtService {
	 public List<DoctorDTO> fetchAllGivenRecordsByExample(DoctorDTO dto);
     public String removeAllDoctors();
}
