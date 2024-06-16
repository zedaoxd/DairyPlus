package com.dairyplus.utils;

import com.dairyplus.dto.OpportunityDTO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class CSVHelper {

    public static ByteArrayInputStream opportunitiesToCSV(Iterable<OpportunityDTO> opportunities) {
        final CSVFormat format = CSVFormat.DEFAULT.withHeader("ID", "Cliente", "Preço por galão", "cotação da moeda");

        try (var out = new ByteArrayOutputStream();
             var csvPrinter = new CSVPrinter(new PrintWriter(out), format)) {
            for (OpportunityDTO opportunity : opportunities) {
                var data = Arrays.asList(
                        String.valueOf(opportunity.proposalId()),
                        opportunity.customer(),
                        String.valueOf(opportunity.gallonPrice()),
                        opportunity.currentPrice()
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
