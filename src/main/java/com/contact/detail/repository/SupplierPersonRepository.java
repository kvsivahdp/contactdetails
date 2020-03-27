/**
 * 
 */
package com.contact.detail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.detail.entity.SupplierPerson;

/**
 *
 */
@Repository
public interface SupplierPersonRepository extends JpaRepository<SupplierPerson, Long>{

}
