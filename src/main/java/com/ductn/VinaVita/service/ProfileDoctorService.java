/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.dto.AddProfileDoctorDTO;
import com.ductn.VinaVita.dto.UpdateProfileDoctorDTO;

import java.util.List;
import java.util.Map;

import com.ductn.VinaVita.models.ProfileDoctor;
import org.springframework.data.domain.Page;

/**
 *
 * @author Administrator
 */
public interface ProfileDoctorService {

    int addProfileDoctor(AddProfileDoctorDTO addProfileDoctorDTO);

    int updateProfileDoctor(UpdateProfileDoctorDTO updateProfileDoctorDTO);

    List<ProfileDoctor> findAllProfileDoctorByActiveTrue();

    ProfileDoctor findProfileDoctorByProfileDoctorIdAndActiveTrue(int profileDoctorId);

    List<ProfileDoctor> findProfileDoctorByUserIdAndActiveTrue(int userId);

    Page<ProfileDoctor> findAllProfileDoctorPageSpec(Map<String, String> params);

    int softDeleteProfileDoctor(int profileDoctorId);
}
