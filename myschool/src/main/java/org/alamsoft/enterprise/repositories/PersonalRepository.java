package org.alamsoft.enterprise.repositories;

import java.util.Optional;

import org.alamsoft.enterprise.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonalRepository extends JpaRepository<Address, String> {
	@Query("select a from Address a")
	  Address[] getAll();
	
	Optional<Address> findByUsername(String username);
}
