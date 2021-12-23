package com.server.vari.model.request.repository;

import com.server.vari.model.request.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
