package com.nt.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Doctor;

public interface DoctorRepo extends PagingAndSortingRepository<Doctor, Integer> {

}
