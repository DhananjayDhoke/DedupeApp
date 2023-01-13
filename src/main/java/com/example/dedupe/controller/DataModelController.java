package com.example.dedupe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.dedupe.entity.DataModel;
import com.example.dedupe.entity.common.RequestModel;
import com.example.dedupe.entity.common.ResponceModel;
import com.example.dedupe.service.DataModelService;

@RestController
@RequestMapping("/api/dedupe")
public class DataModelController {

	@Autowired
	private DataModelService dataModelService;
    
	/**
	 * This api is used to create dummy customer data 
	 */
	@PostMapping("/creatdata")
	public ResponseEntity<DataModel> addDataHandler(@RequestBody DataModel dataModel){

		DataModel createdData = dataModelService.createData(dataModel);

		return new ResponseEntity<>(createdData,HttpStatus.OK);

	}
    
	/**
	 * This api is used to check the customer data validation
	 */
	@GetMapping("/customer-details-validation")
	public ResponseEntity<ResponceModel> getDataHandler(@RequestBody RequestModel requestModel){

		ResponceModel findData = dataModelService.findEntity(requestModel);

		return new ResponseEntity<>(findData,HttpStatus.OK);

	}

}
