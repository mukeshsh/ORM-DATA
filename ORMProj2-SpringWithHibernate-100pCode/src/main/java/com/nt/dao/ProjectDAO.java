package com.nt.dao;

import java.util.List;

import com.nt.entity.Project;

public interface ProjectDAO {
   public Integer insert(Project entity);
   public Project getRecordsById(int id);
   public boolean updateProjectById(int id,int teamSize,double cost);
   public boolean deleteProjectById(int id);
   public List<Project> getProjectByCostRange(double start,double end);
}
