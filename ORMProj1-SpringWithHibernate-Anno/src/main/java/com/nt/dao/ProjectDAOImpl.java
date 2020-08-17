package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.entity.Project2;

@Repository("projDAO")
public class ProjectDAOImpl implements ProjectDAO {
     
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer insert(Project2 entity) {
       int idVal=0;
       //Hibernate template
       idVal=(int) ht.save(entity);
		return idVal;
	}

}
