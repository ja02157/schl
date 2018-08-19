package org.alamsoft.enterprise.repositories;

import org.alamsoft.enterprise.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonalRepository extends JpaRepository<Address, Integer> {
	@Query("select a from Address a")
	  Address[] getAll();
}
