package com.dairyplus.repository;

import com.dairyplus.entity.QuotationEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class QuotationRepository implements PanacheRepositoryBase<QuotationEntity, UUID> {

    public QuotationEntity getLastQuotation() {
        return find("order by date desc").firstResult();
    }

}
