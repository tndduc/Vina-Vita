/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.repository;

import java.util.Optional;

import com.ductn.VinaVita.models.TestResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Repository
@Transactional
public interface TestResultRepository extends JpaRepository<TestResult, Integer> {
    Optional<TestResult> findByTestResultIdAndActiveTrue(Integer testResultId);

    Page<?> findAll(Specification<?> createSpecification, Pageable page);
}
