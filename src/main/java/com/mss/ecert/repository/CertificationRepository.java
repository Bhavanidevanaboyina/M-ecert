package com.mss.ecert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mss.ecert.domain.Certification;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, String> {

}
