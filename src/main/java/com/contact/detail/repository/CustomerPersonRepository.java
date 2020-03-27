/**
 * 
 */
package com.contact.detail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.detail.entity.CustomerPerson;

/**
 *
 */
@Repository
public interface CustomerPersonRepository extends JpaRepository<CustomerPerson, Long>{

}
