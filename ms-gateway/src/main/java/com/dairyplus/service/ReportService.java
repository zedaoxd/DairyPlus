package com.dairyplus.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.dairyplus.dto.OpportunityDTO;

public interface ReportService {
    ByteArrayInputStream generateCSVOpportunityReport();

    List<OpportunityDTO> getOpportunitiesData();
}
