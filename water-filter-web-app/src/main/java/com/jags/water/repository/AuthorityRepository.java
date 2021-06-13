package com.jags.water.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jags.water.entity.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String>{
	
	@Query("SELECT a.authority FROM Authority a WHERE a.username = ?1")
	public List<String> findAuthorities(String username);
}
