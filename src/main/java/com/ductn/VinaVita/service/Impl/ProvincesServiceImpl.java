/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service.Impl;

import com.ductn.VinaVita.models.Provinces;
import com.ductn.VinaVita.repository.ProvincesRepository;
import com.ductn.VinaVita.service.ProvincesService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class ProvincesServiceImpl implements ProvincesService {

    @Autowired
    private ProvincesRepository provincesRepository;
    
    
    @Override
    public List<Provinces> findAllProvinces() {
        return this.provincesRepository.findAll();
    }
    
}
