package com.contact.detail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.detail.dto.SupplierDTO;
import com.contact.detail.entity.Supplier;
import com.contact.detail.entity.SupplierCompany;
import com.contact.detail.entity.SupplierPerson;
import com.contact.detail.repository.SupplierCompanyRepository;
import com.contact.detail.repository.SupplierPersonRepository;
import com.contact.detail.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private SupplierPersonRepository supplierPersonRepository;

	@Autowired
	private SupplierCompanyRepository supplierCompanyRepository;

	public Supplier save(SupplierDTO supplier) {
		try {
			if (supplier.getCompany() != null) {
				SupplierCompany supplierCompany = new SupplierCompany();
				supplierCompany.setCompany(supplier.getCompany());
				supplierCompany.setOrderLeadTime(supplier.getOrderLeadTime());
				supplierCompany.setTaxNum(supplier.getTaxNum());
				supplierCompany.setPhoneNumber(supplier.getPhoneNumber());
				return saveSupplierCompany(supplierCompany);
			} else if (supplier.getPerson() != null) {
				SupplierPerson supplierPerson = new SupplierPerson();
				supplierPerson.setPerson(supplier.getPerson());
				supplierPerson.setOrderLeadTime(supplier.getOrderLeadTime());
				supplierPerson.setTaxNum(supplier.getTaxNum());
				supplierPerson.setPhoneNumber(supplier.getPhoneNumber());
				return saveSupplierPerson(supplierPerson);
			}

		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	public SupplierPerson saveSupplierPerson(SupplierPerson supplierPerson) {
		try {
			return supplierPersonRepository.save(supplierPerson);
		} catch (Exception e) {
			throw e;
		}
	}

	public SupplierCompany saveSupplierCompany(SupplierCompany supplierCompany) {
		try {
			return supplierCompanyRepository.save(supplierCompany);
		} catch (Exception e) {
			throw e;
		}
	}

	public Supplier update(SupplierDTO supplier, Long supplierId) {
		try {
			if (supplier.getCompany() != null) {
				SupplierCompany supplierCompany = new SupplierCompany();
				supplierCompany.setCompany(supplier.getCompany());
				supplierCompany.setOrderLeadTime(supplier.getOrderLeadTime());
				supplierCompany.setTaxNum(supplier.getTaxNum());
				supplierCompany.setPhoneNumber(supplier.getPhoneNumber());
				return updateSupplierCompany(supplierCompany, supplierId);
			} else if (supplier.getPerson() != null) {
				SupplierPerson supplierPerson = new SupplierPerson();
				supplierPerson.setPerson(supplier.getPerson());
				supplierPerson.setOrderLeadTime(supplier.getOrderLeadTime());
				supplierPerson.setTaxNum(supplier.getTaxNum());
				supplierPerson.setPhoneNumber(supplier.getPhoneNumber());
				return updateSupplierPerson(supplierPerson, supplierId);
			}

		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	public SupplierCompany updateSupplierCompany(SupplierCompany supplierCompany, Long supplierId) {
		try {
			Optional<SupplierCompany> isSupplierPresent = supplierCompanyRepository.findById(supplierId);
			if (isSupplierPresent.isPresent()) {
				SupplierCompany supplier = isSupplierPresent.get();
				supplier.getCompany().setCompanyName(supplierCompany.getCompany().getCompanyName());
				supplier.getCompany().setRegNum(supplierCompany.getCompany().getRegNum());
				supplier.setOrderLeadTime(supplierCompany.getOrderLeadTime());
				supplier.setTaxNum(supplierCompany.getTaxNum());
				supplier.setPhoneNumber(supplierCompany.getPhoneNumber());
				return supplierCompanyRepository.save(supplier);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public SupplierPerson updateSupplierPerson(SupplierPerson supplierPerson, Long supplierId) {
		try {
			Optional<SupplierPerson> isSupplierPresent = supplierPersonRepository.findById(supplierId);
			if (isSupplierPresent.isPresent()) {
				SupplierPerson supplier = isSupplierPresent.get();
				supplier.getPerson().setFirstName(supplierPerson.getPerson().getFirstName());
				supplier.getPerson().setLastName(supplierPerson.getPerson().getLastName());
				supplier.setOrderLeadTime(supplierPerson.getOrderLeadTime());
				supplier.setTaxNum(supplierPerson.getTaxNum());
				supplier.setPhoneNumber(supplierPerson.getPhoneNumber());
				return supplierPersonRepository.save(supplier);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Supplier> findAllSuppliers() {
		try {
			return supplierRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	public Supplier findSupplierBySupplierId(Long supplierId) {
		try {
			Optional<Supplier> isSupplierPresent = supplierRepository.findById(supplierId);
			if (isSupplierPresent.isPresent()) {
				Supplier supplier = isSupplierPresent.get();
				return supplier;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void deleteSupplier(Long supplierId) {
		try {
			Optional<Supplier> isSupplierPresent = supplierRepository.findById(supplierId);
			if (isSupplierPresent.isPresent()) {
				supplierRepository.deleteById(supplierId);
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
