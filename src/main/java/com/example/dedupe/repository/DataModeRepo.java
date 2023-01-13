package com.example.dedupe.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dedupe.entity.DataModel;

public interface DataModeRepo extends JpaRepository<DataModel, Integer>{
    
	Optional<DataModel> findByPancard(String pancard);
	Optional<DataModel> findByAadhar(String aadhar);
	Optional<DataModel> findByPassport(String passport);
	
}
