package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
public class Project implements Serializable {
    
	@Id
	@Type(type="int")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer projId;
	
	@Column(length = 20,unique = true,nullable = false)
	@Type(type="string")
	private String projName;
	
	@Column(length = 20,nullable = false)
	@Type(type="int")
	private Integer teamSize;
	
	@Column(length = 20)
	@Type(type="string")
	private String company;
	
	@Column(length = 20)
	@Type(type="string")
	private String location;
	
	@Column(length = 30)
	@Type(type="double")
	private Double cost;
}
