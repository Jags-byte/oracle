package com.jags.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jags.tickets.entity.TicketType;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Integer>{

}
