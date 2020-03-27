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

import com.contact.detail.dto.SupplierDTO;
import com.contact.detail.entity.Supplier;
import com.contact.detail.entity.SupplierCompany;
import com.contact.detail.entity.SupplierPerson;
import com.contact.detail.service.SupplierService;

import io.swagger.annotations.ApiOperation;

/**
 * A RESTFul controller for accessing Supplier information via
 * {@link SupplierService}.
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;

	@ApiOperation(value = "Save Supplier as a Company or Person", response = ResponseData.class)
	@PostMapping("/suppliers/save")
	public ResponseEntity<ResponseData<Supplier>> save(@RequestBody SupplierDTO supplierDTO) {
		ResponseData<Supplier> appResponse = new ResponseData<>();
		try {
			if (supplierDTO.getCompany() != null && supplierDTO.getPerson() != null) {
				appResponse.setResponseMessage("A Supplier can be a person or a company, but not both.");
				return ResponseEntity.ok().body(appResponse);
			}
			appResponse.setPayload(supplierService.save(supplierDTO));
			return ResponseEntity.ok().body(appResponse);
		} catch (Exception e) {
			throw e;
		}
	}

	@ApiOperation(value = "Save Supplier as a Company", response = ResponseData.class)
	@PostMapping("/suppliers/company/save")
	public ResponseEntity<ResponseData<SupplierCompany>> saveCompany(@RequestBody SupplierCompany supplier) {
		ResponseData<SupplierCompany> appResponse = new ResponseData<>();
		try {
			appResponse.setPayload(supplierService.saveSupplierCompany(supplier));
			return ResponseEntity.ok().body(appResponse);
		} catch (Exception e) {
			throw e;
		}
	}

	@ApiOperation(value = "Save Supplier as a Person", response = ResponseData.class)
	@PostMapping("/suppliers/person/save")
	public ResponseEntity<ResponseData<SupplierPerson>> savePerson(@RequestBody SupplierPerson supplier) {
		ResponseData<SupplierPerson> appResponse = new ResponseData<>();
		try {
			appResponse.setPayload(supplierService.saveSupplierPerson(supplier));
			return ResponseEntity.ok().body(appResponse);
		} catch (Exception e) {
			throw e;
		}
	}

	@ApiOperation(value = "Update Supplier as a Company or Person", response = ResponseData.class)
	@PatchMapping("/suppliers/{supplierId}")
	public ResponseEntity<ResponseData<Supplier>> update(@RequestBody SupplierDTO supplierDTO,
			@PathVariable Long supplierId) {
		ResponseData<Supplier> appResponse = new ResponseData<>();
		try {
			if (supplierDTO.getCompany() != null && supplierDTO.getPerson() != null) {
				appResponse.setResponseMessage("A Supplier can be a person or a company, but not both.");
				return ResponseEntity.ok().body(appResponse);
			}
			Supplier updatedSupplier = supplierService.update(supplierDTO, supplierId);
			if (updatedSupplier == null) {
				appResponse.setResponseMessage("Supplier not found");
				return ResponseEntity.ok().body(appResponse);

			}
			appResponse.setPayload(updatedSupplier);
			return ResponseEntity.ok().body(appResponse);
		} catch (Exception e) {
			throw e;
		}
	}

	@ApiOperation(value = "Fetch list of suppliers", response = ResponseData.class)
	@GetMapping("/suppliers")
	public ResponseEntity<ResponseData<List<Supplier>>> fetchAllCustomers() {
		ResponseData<List<Supplier>> appResponse = new ResponseData<>();
		try {
			List<Supplier> supplierList = supplierService.findAllSuppliers();
			if (supplierList == null || supplierList.isEmpty()) {
				appResponse.setResponseMessage("Supplier(s) not found.");
			} else {
				appResponse.setPayload(supplierList);
			}
			return ResponseEntity.ok().body(appResponse);
		} catch (Exception e) {
			throw e;
		}
	}

	@ApiOperation(value = "Fetch a Supplier", response = ResponseData.class)
	@GetMapping("/suppliers/{supplierid}")
	public ResponseEntity<ResponseData<Supplier>> findSupplierBySupplierId(@PathVariable Long supplierid) {
		ResponseData<Supplier> appResponse = new ResponseData<>();
		try {
			Supplier supplier = supplierService.findSupplierBySupplierId(supplierid);
			if (supplier == null) {
				appResponse.setResponseMessage("Supplier not found.");
			} else {
				appResponse.setPayload(supplier);
			}
			return ResponseEntity.ok().body(appResponse);
		} catch (Exception e) {
			throw e;
		}
	}

	@ApiOperation(value = "Delete a supplier")
	@DeleteMapping("/suppliers/{supplierid}")
	public void delete(@PathVariable Long supplierid) {
		try {
			supplierService.deleteSupplier(supplierid);
		} catch (Exception e) {
			throw e;
		}
	}
}
