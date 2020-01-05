package org.alamsoft.enterprise.repositories;

import java.util.Optional;

import org.alamsoft.enterprise.entity.UserIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonalRepository extends JpaRepository<UserIdentity, String> {
	@Query("select a from UserIdentity a")
	UserIdentity[] getAll();
	
	Optional<UserIdentity> findByUsername(String username);
}
