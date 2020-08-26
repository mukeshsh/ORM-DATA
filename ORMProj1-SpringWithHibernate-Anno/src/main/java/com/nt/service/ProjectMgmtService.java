package com.nt.service;

import java.util.List;

import com.nt.dto.ProjectDTO;

public interface ProjectMgmtService {
   public String registerProject(ProjectDTO dto);
   public Object fetchRecordsById(int id);
   public String updateProectById(int id,int teamSize,double cost);
   public String removeProjectById(int id);
   public List<ProjectDTO> fetchRecordsByRange(double start,double end);
}
