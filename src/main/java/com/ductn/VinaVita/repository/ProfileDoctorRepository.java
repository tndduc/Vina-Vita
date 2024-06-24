/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.repository;

import com.ductn.VinaVita.models.ProfileDoctor;
import com.ductn.VinaVita.models.User;

import java.util.List;
import java.util.Optional;
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
public interface ProfileDoctorRepository extends JpaRepository<ProfileDoctor, Integer> {

    Optional<ProfileDoctor> findProfileDoctorByProfileDoctorIdAndActiveTrue(int profileDoctorId);

    List<ProfileDoctor> findAllProfileDoctorByActiveTrue();

    List<ProfileDoctor> findProfileDoctorByUserIdAndActiveTrue(User userId);

    Page<ProfileDoctor> findAll(Specification<ProfileDoctor> createSpecification, Pageable page);
}
