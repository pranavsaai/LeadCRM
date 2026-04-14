package com.leadcrm.finder.service;

import com.leadcrm.finder.model.Lead;
import com.leadcrm.finder.model.Signals;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoringService {

    public Lead enrichLead(Lead lead) {

        int score = 0;
        List<String> insights = new ArrayList<>();

        Signals signals = lead.getSignals();
        System.out.println("Signals received: " + signals);

        if (signals != null && signals.isHiring()) {
            score += 30;
            insights.add("Company is actively hiring");
        }


        if (signals != null && signals.isHasFunding()) {
            score += 30;
            insights.add("Company has recent funding");
        }

        if (signals != null && signals.isActiveOnline()) {
            score += 10;
            insights.add("Company is active online");
        }
        if ("fintech".equalsIgnoreCase(lead.getIndustry())) {
            score += 20;
            insights.add("Industry matches target market");
        }

        if (lead.getCompanySize() >= 20 && lead.getCompanySize() <= 200) {
            score += 20;
            insights.add("Company size is ideal");
        }

        lead.setScore(Math.min(score, 100));
        lead.setInsights(insights);

        return lead;
    }
}