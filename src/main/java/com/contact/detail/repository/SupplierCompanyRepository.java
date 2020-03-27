/**
 * 
 */
package com.contact.detail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.detail.entity.SupplierCompany;

/**
 *
 */
@Repository
public interface SupplierCompanyRepository extends JpaRepository<SupplierCompany, Long>{

}
