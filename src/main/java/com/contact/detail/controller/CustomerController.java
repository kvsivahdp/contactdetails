/**
 * 
 */
package com.contact.detail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.detail.dto.CustomerDTO;
import com.contact.detail.entity.Customer;
import com.contact.detail.entity.CustomerCompany;
import com.contact.detail.entity.CustomerPerson;
import com.contact.detail.service.CustomerService;

import io.swagger.annotations.ApiOperation;

/**
 * A RESTFul controller for accessing Customer information via
 * {@link CustomerService}.
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@ApiOperation(value = "Save Customer as a Company or Person", response = ResponseData.class)
	@PostMapping("/customers/save")
	public ResponseEntity<ResponseData<Customer>> save(@RequestBody CustomerDTO customerDTO) {
		ResponseData<Customer> appResponse = new ResponseData<>();
		try {
			if(customerDTO.getCompany()!=null && customerDTO.getPerson()!=null) {
				appResponse.setResponseMessage("A customer can be a person or a company, but not both.");
				return ResponseEntity.ok().body(appResponse);
			}
			appResponse.setPayload(customerService.save(customerDTO));
			return ResponseEntity.ok().body(appResponse);
		} catch (Exception e) {
			throw e;
		}
	}

	@ApiOperation(value = "Save Customer as a Company", response = ResponseData.class)
	@PostMapping("/customers/company/save")
	public ResponseEntity<ResponseData<CustomerCompany>> saveCompany(@RequestBody CustomerCompany customer) {
		ResponseData<CustomerCompany> appResponse = new ResponseData<>();
		try {
			appResponse.setPayload(customerService.saveCustomerCompany(customer));
			return ResponseEntity.ok().body(appResponse);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@ApiOperation(value = "Save Customer as a Person", response = ResponseData.class)
	@PostMapping("/customers/person/save")
	public ResponseEntity<ResponseData<CustomerPerson>> savePerson(@RequestBody CustomerPerson customer) {
		ResponseData<CustomerPerson> appResponse = new ResponseData<>();
		try {
			appResponse.setPayload(customerService.saveCustomerPerson(customer));
			return ResponseEntity.ok().body(appResponse);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@ApiOperation(value = "Update Customer as a Company or Person", response = ResponseData.class)
	@PatchMapping("/customers/{customerId}")
	public ResponseEntity<ResponseData<Customer>> update(@RequestBody CustomerDTO customerDTO, @PathVariable Long customerId) {
		ResponseData<Customer> appResponse = new ResponseData<>();
		try {
			if(customerDTO.getCompany()!=null && customerDTO.getPerson()!=null) {
				appResponse.setResponseMessage("A customer can be a person or a company, but not both.");
				return ResponseEntity.ok().body(appResponse);
			}
			Customer updatedCustomer = customerService.update(customerDTO, customerId);
			if(updatedCustomer==null) {
				appResponse.setResponseMessage("Customer not found");
				return ResponseEntity.ok().body(appResponse);
				
			}
			appResponse.setPayload(updatedCustomer);
			return ResponseEntity.ok().body(appResponse);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@ApiOperation(value = "Fetch list of customers", response = ResponseData.class)
	@GetMapping("/customers")
	public ResponseEntity<ResponseData<List<Customer>>> fetchAllCustomers() {
		ResponseData<List<Customer>> appResponse = new ResponseData<>();
		try {
			List<Customer> customerList = customerService.findAllCustomers();
			if(customerList==null || customerList.isEmpty()) {
				appResponse.setResponseMessage("Customer(s) not found.");
			} else {
				appResponse.setPayload(customerList);
			}
			return ResponseEntity.ok().body(appResponse);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@ApiOperation(value = "Fetch a customer", response = ResponseData.class)
	@GetMapping("/customers/{customerid}")
	public ResponseEntity<ResponseData<Customer>> findCustomerByCustomerId(@PathVariable Long customerid) {
		ResponseData<Customer> appResponse = new ResponseData<>();
		try {
			Customer customer = customerService.findCustomerByCustomerId(customerid);
			if(customer==null) {
				appResponse.setResponseMessage("Customer not found.");
			} else {
				appResponse.setPayload(customer);
			}
			return ResponseEntity.ok().body(appResponse);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@ApiOperation(value = "Delete a customer")
	@DeleteMapping("/customers/{customerid}")
	public void delete(@PathVariable Long customerid) {
		try {
			customerService.deleteCustomer(customerid);
		} catch (Exception e) {
			throw e;
		}
	}
}
