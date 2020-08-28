package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.ProjectDAO;
import com.nt.dto.ProjectDTO;
import com.nt.entity.Project;

@Service("projService")
@Transactional(transactionManager = "hbTxMgmr")
public class ProjectMgmtServiceImpl implements ProjectMgmtService {
   
	@Autowired
	private ProjectDAO dao;
	
	@Override
	public String registerProject(ProjectDTO dto) {
		Project entity=null;
		Integer idVal=0;
		  //convert DTO to BO/Entity
		entity=new Project();
		BeanUtils.copyProperties(dto,entity);
		  //use DAO
		idVal=dao.insert(entity);
		return "Project is registered with the id ::"+idVal;
	}

	@Override
	public Object fetchRecordsById(int id) {
		Project proj=null;
		ProjectDTO dto=null;
      //use dao
		proj=dao.getRecordsById(id);
		//convert to entity object to dto
		if(proj!=null) {
			dto=new ProjectDTO();
			BeanUtils.copyProperties(proj, dto);
		}
		return dto!=null?dto:"Record not fount";
	}

	@Override
	public String updateProectById(int id, int teamSize, double cost) {
      boolean flag=false;
		//use dao
      flag=dao.updateProjectById(id, teamSize, cost);
      return flag==false?"record not found for update":"Record Updated";

	}

	@Override
	public String removeProjectById(int id) {
      boolean flag=false;
		//dao
      flag=dao.deleteProjectById(id);
		return flag==false?"Record not found for deletion":"Record deleted ";
	}

	@Override
	public List<ProjectDTO> fetchRecordsByRange(double start, double end) {
      List<Project> listEntities=null;
      List<ProjectDTO> listDTO=new ArrayList<ProjectDTO>();
      //use dao
      listEntities=dao.getProjectByCostRange(start, end);
      //convert listEntites to listDTO
      listEntities.forEach(entity->{
    	  ProjectDTO dto=new ProjectDTO();
    	  BeanUtils.copyProperties(entity, dto);
    	  listDTO.add(dto);
      });
		return listDTO;
	}

}
