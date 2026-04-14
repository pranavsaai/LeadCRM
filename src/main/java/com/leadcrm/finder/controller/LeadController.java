package com.leadcrm.finder.controller;

import com.leadcrm.finder.model.Lead;
import com.leadcrm.finder.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping
    public Lead addLead(@RequestBody Lead lead) {
        return leadService.saveLead(lead);
    }

    @GetMapping
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    @GetMapping("/high")
    public List<Lead> getHighScoreLeads(@RequestParam int score) {
        return leadService.getHighScoreLeads(score);
    }
}