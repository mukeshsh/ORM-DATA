package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProjectDTO implements Serializable {
   
	private Integer projId;
	private String projName;
	private Integer teamSize;
	private String company;
	private String location;
	private Double cost;
}
