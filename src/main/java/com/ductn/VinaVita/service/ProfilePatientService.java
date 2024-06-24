/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.dto.AddProfilePatientDTO;
import com.ductn.VinaVita.dto.UpdateProfilePatientDTO;
import com.ductn.VinaVita.models.ProfilePatient;

import java.util.List;
import java.util.Optional;

import com.ductn.VinaVita.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author Administrator
 */
public interface ProfilePatientService {

    int addProfilePatient(AddProfilePatientDTO addProfilePatientDTO);

    int updateProfilePatient(UpdateProfilePatientDTO updateProfilePatientDTO);

    ProfilePatient findProfilePatientByProfilePatientIdAndActiveTrue(int profilePatientId);

    Optional<ProfilePatient> findProfilePatientByProfilePatientIdAndActiveTrueOptional(int profilePatientId);

    List<ProfilePatient> findProfilePatientByUserIdAndActiveTrue(int userId);

    int softDeleteProfilePatient(int profilePatientId);

    List<?> findProfilePatientByUserIdAndIsLockAndActiveTrue(User userId, Boolean lock);

    Page<?> findAllProfilePatientPageSpec(Specification<?> createSpecification, Pageable page);
}
