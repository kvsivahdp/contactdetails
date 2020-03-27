package com.contact.detail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.detail.dto.CustomerDTO;
import com.contact.detail.entity.Customer;
import com.contact.detail.entity.CustomerCompany;
import com.contact.detail.entity.CustomerPerson;
import com.contact.detail.repository.CustomerCompanyRepository;
import com.contact.detail.repository.CustomerPersonRepository;
import com.contact.detail.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository; 
	
	@Autowired
	private CustomerPersonRepository customerPersonRepository; 
	
	@Autowired
	private CustomerCompanyRepository customerCompanyRepository;
	
	public Customer save(CustomerDTO customer) {
		try {
			if(customer.getCompany()!=null) {
				CustomerCompany customerCompany = new CustomerCompany();
				customerCompany.setCompany(customer.getCompany());
				customerCompany.setCustNum(customer.getCustNum());
				customerCompany.setLastOrderDate(customer.getLastOrderDate());
				customerCompany.setPhoneNumber(customer.getPhoneNumber());
				return saveCustomerCompany(customerCompany);
			}else if(customer.getPerson() != null){
				CustomerPerson customerPerson = new CustomerPerson();
				customerPerson.setCustNum(customer.getCustNum());
				customerPerson.setLastOrderDate(customer.getLastOrderDate());
				customerPerson.setPerson(customer.getPerson());
				customerPerson.setPhoneNumber(customer.getPhoneNumber());
				return saveCustomerPerson(customerPerson);
			}
			
		}catch(Exception e) {
			throw e;
		}
		return null;
	}
	
	public CustomerPerson saveCustomerPerson(CustomerPerson customerPerson) {
		try {
			return customerPersonRepository.save(customerPerson);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public CustomerCompany saveCustomerCompany(CustomerCompany customerCompany) {
		try {
			return customerCompanyRepository.save(customerCompany);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Customer update(CustomerDTO customer, Long customerId) {
		try {
			if(customer.getCompany()!=null) {
				CustomerCompany customerCompany = new CustomerCompany();
				customerCompany.setCompany(customer.getCompany());
				customerCompany.setCustNum(customer.getCustNum());
				customerCompany.setLastOrderDate(customer.getLastOrderDate());
				customerCompany.setPhoneNumber(customer.getPhoneNumber());
				return updateCustomerCompany(customerCompany, customerId);
			}else if(customer.getPerson() != null){
				CustomerPerson customerPerson = new CustomerPerson();
				customerPerson.setCustNum(customer.getCustNum());
				customerPerson.setLastOrderDate(customer.getLastOrderDate());
				customerPerson.setPerson(customer.getPerson());
				customerPerson.setPhoneNumber(customerPerson.getPhoneNumber());
				return updateCustomerPerson(customerPerson,customerId);
			}
			
		}catch(Exception e) {
			throw e;
		}
		return null;
	}
	
	public CustomerCompany updateCustomerCompany(CustomerCompany customerCompany,Long customerId) {
		try {
			Optional<CustomerCompany> isCustomerPresent = customerCompanyRepository.findById(customerId);
			if(isCustomerPresent.isPresent()) {
				CustomerCompany customer = isCustomerPresent.get();
				customer.getCompany().setCompanyName(customerCompany.getCompany().getCompanyName());
				customer.getCompany().setRegNum(customerCompany.getCompany().getRegNum());
				customer.setCustNum(customerCompany.getCustNum());
				customer.setLastOrderDate(customer.getLastOrderDate());
				customer.setPhoneNumber(customerCompany.getPhoneNumber());
				return customerCompanyRepository.save(customer);
			}else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public CustomerPerson updateCustomerPerson(CustomerPerson customerPerson,Long customerId) {
		try {
			Optional<CustomerPerson> isCustomerPresent = customerPersonRepository.findById(customerId);
			if(isCustomerPresent.isPresent()) {
				CustomerPerson customer = isCustomerPresent.get();
				customer.getPerson().setFirstName(customerPerson.getPerson().getFirstName());
				customer.getPerson().setLastName(customerPerson.getPerson().getLastName());
				customer.setCustNum(customerPerson.getCustNum());
				customer.setLastOrderDate(customerPerson.getLastOrderDate());
				customer.setPhoneNumber(customerPerson.getPhoneNumber());
				return customerPersonRepository.save(customer);
			}else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Customer> findAllCustomers(){
		try {
			return customerRepository.findAll();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public Customer findCustomerByCustomerId(Long customerId) {
		try {
			Optional<Customer> isCustomerPresent = customerRepository.findById(customerId);
			if(isCustomerPresent.isPresent()) {
				Customer customer = isCustomerPresent.get();
				return customer;
			}else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void deleteCustomer(Long customerId) {
		try {
			Optional<Customer> isCustomerPresent = customerRepository.findById(customerId);
			if(isCustomerPresent.isPresent()) {
				customerRepository.deleteById(customerId);
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
