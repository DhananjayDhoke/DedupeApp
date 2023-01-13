package com.example.dedupe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dedupe.entity.DataModel;
import com.example.dedupe.entity.common.RequestModel;
import com.example.dedupe.entity.common.ResponceModel;
import com.example.dedupe.exception.ResourceNotFoundException;
import com.example.dedupe.repository.DataModeRepo;
import com.example.dedupe.service.DataModelService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DataModelServiceIml implements DataModelService{

	@Autowired
	private DataModeRepo dataModeRepo;

	@Override
	public DataModel createData(DataModel dataModel) {

		return dataModeRepo.save(dataModel);
	}

	@Override
	public ResponceModel findEntity(RequestModel requestModel){
		if(requestModel.getSearchType().equalsIgnoreCase("pan")) {
			log.info("findByPancard method start");
			dataModeRepo.findByPancard(requestModel.getSearchValue()).orElseThrow(()-> new ResourceNotFoundException("Pancard is not found"));
			log.info("findByPancard method end");
			return ResponceModel
					.builder()
					.idType("panCard")
					.message("success")
					.status(true)
					.build();
		}
		else if(requestModel.getSearchType().equalsIgnoreCase("aadhar")) {
			log.info("findByAddharcard method start");
			dataModeRepo.findByAadhar(requestModel.getSearchValue()).orElseThrow(()-> new ResourceNotFoundException("Aadhar is not found"));
			log.info("findByAddharcard method end");
			return ResponceModel
					.builder()
					.idType("aadharCard")
					.message("success")
					.status(true)
					.build();
		}
		else if(requestModel.getSearchType().equalsIgnoreCase("passport")){
			log.info("findByPassport method start");
			dataModeRepo.findByPassport(requestModel.getSearchValue()).orElseThrow(()-> new ResourceNotFoundException("Passport is not found"));
			log.info("findByPassport method end");
			return ResponceModel
					.builder()
					.idType("passPort")
					.message("success")
					.status(true)
					.build();
		}
		
		throw new ResourceNotFoundException("Please Enter correct searchType!!");

	}

}
