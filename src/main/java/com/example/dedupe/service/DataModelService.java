package com.example.dedupe.service;

import com.example.dedupe.entity.DataModel;
import com.example.dedupe.entity.common.RequestModel;
import com.example.dedupe.entity.common.ResponceModel;

public interface DataModelService {
   
	DataModel createData (DataModel dataModel);
	ResponceModel findEntity (RequestModel requestModel);
}
