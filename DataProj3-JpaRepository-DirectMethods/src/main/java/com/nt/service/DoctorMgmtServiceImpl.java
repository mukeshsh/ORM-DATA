package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.dto.DoctorDTO;
import com.nt.entity.Doctor;
import com.nt.repo.DoctorRepo;

@Service("docService")
public class DoctorMgmtServiceImpl implements DoctorMgmtService {
  
	@Autowired
	private DoctorRepo docRepo;
	@Override
	public List<DoctorDTO> fetchAllGivenRecordsByExample(DoctorDTO dto) {
        Doctor entity=null;
        Example<Doctor> example=null;
        List<Doctor> docEntities=null;
        List<DoctorDTO> dDTO=new ArrayList();
        //convert dto to entities
        entity=new Doctor();
        BeanUtils.copyProperties(dto, entity);
        //prepare example object
        example=Example.of(entity);
        //use repository
        docEntities=docRepo.findAll(example);
        //convert docEntity to dDTO
        docEntities.forEach(e->{
        	DoctorDTO dto1=new DoctorDTO();
        	BeanUtils.copyProperties(e, dto1);
        	dDTO.add(dto1);
        });
		return dDTO;
	}
	@Override
	public String removeAllDoctors() {
      boolean flag=true;
      //use repo
      if(docRepo.count()>=1) {
    	  docRepo.deleteAllInBatch();
    	  flag=true;
      }
      else {
    	  flag=false;
      }
		return flag?"All Doctors are deleted":"No Doctor found to deletion";
	}

}
