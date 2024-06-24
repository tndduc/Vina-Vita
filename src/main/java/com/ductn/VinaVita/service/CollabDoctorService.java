/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.dto.AddCollabDoctorDTO;

import java.util.Map;

import com.ductn.VinaVita.models.CollabDoctor;
import org.springframework.data.domain.Page;

/**
 *
 * @author Administrator
 */
public interface CollabDoctorService {
    int addCollabDoctor(AddCollabDoctorDTO addCollabDoctorDTO);

    Page<CollabDoctor> findAllCollabDoctorPageSpec(Map<String, String> params);

    int acceptCollabDoctor(int collabDoctorId);

    int denyCollabDoctor(int collabDoctorId);
}
