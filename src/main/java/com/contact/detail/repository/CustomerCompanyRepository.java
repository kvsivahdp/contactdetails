/**
 * 
 */
package com.contact.detail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.detail.entity.CustomerCompany;

/**
 *
 */
@Repository
public interface CustomerCompanyRepository extends JpaRepository<CustomerCompany, Long>{

}
