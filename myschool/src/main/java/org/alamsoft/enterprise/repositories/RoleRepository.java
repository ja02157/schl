package org.alamsoft.enterprise.repositories;

import org.alamsoft.enterprise.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Roles, String> {
	@Query("select a from Roles a")
	Roles[] getAll();
}
