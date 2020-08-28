package com.nt.service;

import java.util.List;

import com.nt.dto.CustomerDTO;

public interface CustomerMgmtService {
    public String customerRegister(CustomerDTO dto);
    public String groupRegisterCustomer(List<CustomerDTO> listDTO);
    public String removeCustomerById(int cno);
    public String removeBulkCustomers(Iterable<CustomerDTO> itDTO);
    public long fetchCountRecords();
    public Iterable<CustomerDTO> fetchAllCustmores();
    
}
