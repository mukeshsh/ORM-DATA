package com.nt.service;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.dto.DoctorDTO;
import com.nt.entity.Doctor;
import com.nt.repo.DoctorRepo;

@Service("docService")
public class DoctorMgmtServiceImpl implements DoctorMgmtService {
     
	@Autowired
	private DoctorRepo docRepo;
	@Override
	public Iterable<DoctorDTO> fetchAllRecordsSortByProperty(String property, boolean asc) {
      Iterable<Doctor> itEntities=null;
      Iterable<DoctorDTO> dDTO=new ArrayList();
      //use repository
      itEntities=docRepo.findAll(Sort.by(asc?Direction.ASC:Direction.DESC,property));
      //convert entities to dDTO
      itEntities.forEach(entity->{
    	  DoctorDTO dto=new DoctorDTO();
    	  BeanUtils.copyProperties(entity, dto);
    	  ((ArrayList) dDTO).add(dto);
      });
		return dDTO;
	}
	@Override
	public Iterable<DoctorDTO> fetchAllREcordsSortByProperties(boolean asc, String... properties) {
      Iterable<Doctor> doc=null;
      Iterable<DoctorDTO> dDTO=new ArrayList();
      //use repo
      doc=docRepo.findAll(Sort.by(asc?Direction.ASC:Direction.DESC,properties));
      //conersion
      doc.forEach(e->{
    	  DoctorDTO dto=new DoctorDTO();
    	  BeanUtils.copyProperties(e, dto);
    	  ((ArrayList) dDTO).add(dto);
      });
		return dDTO;
	}
	@Override
	public Iterable<DoctorDTO> fetchRecordsBypageNoAndPageSize(int pageNo, int pageSize) {
		Pageable pageable=null;
		Slice<Doctor> slice=null;
		Page<Doctor> page=null;
        Iterable<Doctor> itEntity=null;
        Iterable<DoctorDTO> dDTO=new ArrayList<DoctorDTO>();
        //create pageable object
        pageable=PageRequest.of(pageNo, pageSize);
        //get page object
      //  page=docRepo.findAll(pageable);
        slice=docRepo.findAll(pageable);  
        //conver page object into List object
        itEntity=slice.getContent();
        System.out.println(slice.getNumber()+"  "+slice.getNumberOfElements()+"  "+slice.getSize()+" "+slice.isEmpty()+" "+slice.isFirst());
     //   System.out.println(page.getNumber()+" "+page.getNumberOfElements()+"  "+page.getTotalElements()+"  "+page.getSize()+"  "+page.hasContent()+"  "+page.isEmpty()+" "+page.isLast());
        
        //conver itentity to idto
        itEntity.forEach(en->{
        	DoctorDTO dto=new DoctorDTO();
        	BeanUtils.copyProperties(en, dto);
        	((ArrayList) dDTO).add(dto);
        });
		return dDTO;
	}
	@Override
	public void fetchRecordsByPagination(int pageSize) {
     Page<Doctor> page=null;
     long recordsCount=0;
     long pageCount=0;
     Pageable pageable=null;
     //no of records
     recordsCount=docRepo.count();
     pageCount=recordsCount/pageSize;
     pageCount=recordsCount%pageSize==0?pageCount:++pageCount;
     //display records throug pagination
     for(int i=0;i<pageCount;++i) {
    	 pageable=PageRequest.of(i, pageSize,Direction.ASC,"dName");
    	 page=docRepo.findAll(pageable);
    	 page.getContent().forEach(System.out::println);
    	 System.out.println("page"+(i+1)+"of  "+page.getTotalPages());
     }
	}

}
