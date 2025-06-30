package com.app.glorepay.repository;

import com.app.glorepay.entity.PublicTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// make this into a public transport repository
@Repository
public interface PublicTransportRepository extends JpaRepository<PublicTransport, Long> {
    public PublicTransport findBypublicTransportId(Long publicTransportId);
}
