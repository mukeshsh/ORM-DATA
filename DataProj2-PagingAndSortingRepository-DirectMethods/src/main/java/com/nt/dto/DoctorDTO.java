package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DoctorDTO implements Serializable{
      private Integer dId;
      private String dName;
      private String personalAddrs;
      private Long mob;
      private String Hoslocation;
      private String email;
      private Double salary;
}
