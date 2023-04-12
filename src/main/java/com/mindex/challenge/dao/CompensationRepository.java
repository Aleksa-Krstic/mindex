package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


// New repository interface to get Compensation object from the mongoDB
@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {

    // Query returns a compensation object by the value of the employee object's ID
    Compensation findByEmployeeEmployeeId(String id);

}