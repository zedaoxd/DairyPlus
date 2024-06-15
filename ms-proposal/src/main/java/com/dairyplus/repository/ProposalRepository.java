package com.dairyplus.repository;

import com.dairyplus.entity.ProposalEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class ProposalRepository implements PanacheRepositoryBase<ProposalEntity, UUID>{

    public UUID findIdByCustomer(String customer) {
        return find("customer", customer).firstResultOptional().map(ProposalEntity::getId).orElse(null);
    }
}
