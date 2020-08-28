package com.nt.service;

import com.nt.dto.DoctorDTO;

public interface DoctorMgmtService {
	 public Iterable<DoctorDTO> fetchAllRecordsSortByProperty(String property,boolean asc);
	 public Iterable<DoctorDTO> fetchAllREcordsSortByProperties(boolean asc,String...properties);
	 public Iterable<DoctorDTO>fetchRecordsBypageNoAndPageSize(int pageNo,int pageSize);
	 public void fetchRecordsByPagination(int pageSize);
}
