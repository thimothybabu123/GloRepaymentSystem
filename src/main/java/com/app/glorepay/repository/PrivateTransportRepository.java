package com.app.glorepay.repository;

import com.app.glorepay.entity.PrivateTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

// make this into a private transport repository
@Repository
public interface PrivateTransportRepository extends JpaRepository<PrivateTransport, Long> {
    public PrivateTransport findByprivateTransportId(Long privateTransportId);
}
