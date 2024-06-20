package com.dairyplus.utils;

import com.dairyplus.dto.OpportunityDTO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CSVHelper {

    public static ByteArrayInputStream opportunitiesToCSV(Iterable<OpportunityDTO> opportunities) {
        final CSVFormat format = CSVFormat.DEFAULT.withHeader("ID", "Cliente", "Preço por galão", "cotação da moeda");

        try (var out = new ByteArrayOutputStream();
                var writer = new PrintWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
                var csvPrinter = new CSVPrinter(writer, format)) {
            for (OpportunityDTO opportunity : opportunities) {
                var data = Arrays.asList(
                        String.valueOf(opportunity.proposalId()),
                        opportunity.customer(),
                        String.valueOf(opportunity.gallonPrice()),
                        opportunity.currentPrice());

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}