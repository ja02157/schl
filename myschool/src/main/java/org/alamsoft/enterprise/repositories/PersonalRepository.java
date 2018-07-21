package org.alamsoft.enterprise.repositories;

import javax.transaction.Transactional;

import org.alamsoft.enterprise.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PersonalRepository extends JpaRepository<Address, Integer> {

}
