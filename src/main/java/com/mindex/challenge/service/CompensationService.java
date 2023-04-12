package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

// CompensationService to interact with the database.
public interface CompensationService {

    Compensation create(Compensation compensation);

    Compensation read(String id);

}
