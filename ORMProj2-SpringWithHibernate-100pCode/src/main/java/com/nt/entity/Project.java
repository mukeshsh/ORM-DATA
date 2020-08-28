package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
public class Project implements Serializable {
	@Id
	@Type(type="int")
	@GeneratedValue(strategy = GenerationType.AUTO)
  private Integer projId;
	
	@Column(length=20,unique = true,nullable = false)
	@Type(type="string")
  private String projName;
	
	@Type(type="int")
  private Integer teamSize;
	
	@Column(length=20,nullable=false)
	@Type(type="string")
  private String company;
	
	@Column(length=10)
	@Type(type="string")
  private String location;
	
	@Type(type="double")
  private Double cost;

}