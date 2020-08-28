package com.nt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CustomerDTO {
	public CustomerDTO() {
		System.out.println("CustomerDTO::0-param Constructor");
	}
	public CustomerDTO(int cno) {
		this.cno=cno;
		System.out.println("CustomerDTO::1 param Constructor");
	}
	private Integer cno;
	private String cname;
	private String cadd;
	private double billAmt;
}
