package com.leadcrm.finder.service;

import com.leadcrm.finder.model.Lead;
import com.leadcrm.finder.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private ScoringService scoringService;
    public Lead saveLead(Lead lead) {
        lead = scoringService.enrichLead(lead);
        return leadRepository.save(lead);
    }
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public List<Lead> getHighScoreLeads(int score) {
        return leadRepository.findByScoreGreaterThan(score);
    }
}