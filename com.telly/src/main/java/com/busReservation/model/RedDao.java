package com.busReservation.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RedDao extends PagingAndSortingRepository<Red, String>{
	
	
}
