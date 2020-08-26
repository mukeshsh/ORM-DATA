package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.entity.Project;

@Repository("projDAO")
public class ProjectDAOImpl implements ProjectDAO {
	private static final String COST_RANGE="FROM com.nt.entity.Project WHERE cost>=:min AND cost<=:max";
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer insert(Project entity) {
		int idVal=0;
		//Hibernate template
		idVal=(int) ht.save(entity);
		return idVal;
	}

	@Override
	public Project getRecordsById(int id) {
		Project proj=null;
		//load object
		proj=ht.get(Project.class, id);
		return proj;
	}

	@Override
	public boolean updateProjectById(int id, int teamSize, double cost) {
		Project proj=null;
		boolean flag=false;
		//load the object by id
		proj=ht.get(Project.class, id);
		if(proj!=null) {
			//update project
			proj.setTeamSize(teamSize);
			proj.setCost(cost);
			ht.update(proj);
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean deleteProjectById(int id) {
		Project proj=null;
		boolean flag=false;
		//load the object
		proj=ht.get(Project.class, id);
		if(proj!=null) {
			//delete the object
			ht.delete(proj);
			flag =true;
		}
		return flag;
	}

	@Override
	public List<Project> getProjectByCostRange(double start, double end) {
		List<Project> list=null;
		//load object
		list=(List<Project>) ht.findByNamedParam(COST_RANGE, new String[] {"min", "max"},new Object[] {start,end});
		return list;
	}
}

