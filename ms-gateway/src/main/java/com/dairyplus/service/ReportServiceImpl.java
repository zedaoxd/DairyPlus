package com.dairyplus.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.dairyplus.client.ReportRestClient;
import com.dairyplus.dto.OpportunityDTO;
import com.dairyplus.utils.CSVHelper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ReportServiceImpl implements ReportService {

    @Inject
    @RestClient
    ReportRestClient reportRestClient;

    @Override
    public ByteArrayInputStream generateCSVOpportunityReport() {
        var data = reportRestClient.getOpportunitiesData();
        return CSVHelper.opportunitiesToCSV(data);
    }

    @Override
    public List<OpportunityDTO> getOpportunitiesData() {
        return reportRestClient.getOpportunitiesData();
    }
}
