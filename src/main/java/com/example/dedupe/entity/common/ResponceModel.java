package com.example.dedupe.entity.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponceModel {
    
	private String idType;
	private String message;
	private boolean status;
	
}
