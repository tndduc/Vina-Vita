/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service.Impl;

import com.ductn.VinaVita.components.cloudinary.CloudinaryComponent;
import com.ductn.VinaVita.models.Specialty;
import com.ductn.VinaVita.repository.SpecialtyRepository;
import com.ductn.VinaVita.service.SpecialtyService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    CloudinaryComponent cloudinaryComponent;

    @Override
    public List<Specialty> findSpecialtyByActiveTrue() {
        return this.specialtyRepository.findSpecialtyByActiveTrue();
    }

    @Override
    public Optional<Specialty> findSpecialtyBySpecialtyIdAndActiveTrue(int specialtyId) {
        try {
            return this.specialtyRepository.findSpecialtyBySpecialtyIdAndActiveTrue(specialtyId);
        } catch (NoSuchElementException ex) {
            return null;
        }

    }

    @Override
    public Specialty addSpecialty(Specialty specialty, MultipartFile avatar) {
        if (avatar != null && !avatar.isEmpty()) {
            String linkCloudinaryAvatar = cloudinaryComponent.Cloudinary(avatar).get("secure_url").toString();
            specialty.setAvatar(linkCloudinaryAvatar);
        }

        return this.specialtyRepository.save(specialty);
    }

    @Override
    public Specialty updateSpecialty(Specialty specialty, MultipartFile avatar) {
        if (avatar != null && !avatar.isEmpty()) {
            String linkCloudinaryAvatar = cloudinaryComponent.Cloudinary(avatar).get("secure_url").toString();
            specialty.setAvatar(linkCloudinaryAvatar);
        }

        return this.specialtyRepository.save(specialty);
    }

}
