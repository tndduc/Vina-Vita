/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.repository;

import com.ductn.VinaVita.models.CollabDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */

@Repository
@Transactional
public interface CollabDoctorRepository
        extends JpaRepository<CollabDoctor, Integer>, JpaSpecificationExecutor<CollabDoctor> {

    // Page<CollabDoctor> findAll(Specification<CollabDoctor> createSpecification,
    // Pageable page);

}
