package com.dairyplus.scheduler;

import com.dairyplus.service.QuotationService;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class QuotationScheduler {

    private final QuotationService quotationService;

    @Transactional
    @Scheduled(every = "35s", identity = "task-job")
    void schedule() {
        quotationService.getCurrentPrice();
    }

    @Transactional
    // Run every day at midnight
    @Scheduled(cron = "0 0 0 * * ?")
    void cleanDatabase() {
        quotationService.cleanDatabase();
    }
}
