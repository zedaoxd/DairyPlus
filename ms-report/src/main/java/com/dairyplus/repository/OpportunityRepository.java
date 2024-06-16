package com.dairyplus.repository;

import com.dairyplus.entity.OpportunityEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class OpportunityRepository implements PanacheRepositoryBase<OpportunityEntity, UUID> {
}
