package com.busReservation.model;


import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
public interface TransporterDao extends PagingAndSortingRepository<Transporter,Long>{

}
