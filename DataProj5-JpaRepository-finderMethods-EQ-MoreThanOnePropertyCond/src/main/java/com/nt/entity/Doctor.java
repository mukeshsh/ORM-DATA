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
public class Doctor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type="int")
	private Integer dId;

	@Column(length = 20)
	@Type(type="string")
	private String dName;

	@Column(length = 25)
	@Type(type="string")
	private String personalAddrs;

	@Column(length = 20)
	@Type(type="long")
	private Long mob;

	@Column(length = 30)
	@Type(type="string")
	private String Hoslocation;

	@Column(length = 30)
	@Type(type="string")
	private String email;

	@Column(length = 10)
	@Type(type="double")
	private Double salary;

}
