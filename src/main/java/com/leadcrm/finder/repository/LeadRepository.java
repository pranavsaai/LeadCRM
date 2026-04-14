package com.leadcrm.finder.repository;

import com.leadcrm.finder.model.Lead;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface LeadRepository extends MongoRepository<Lead, String> {

    List<Lead> findByIndustry(String industry);

    List<Lead> findByScoreGreaterThan(int score);
}