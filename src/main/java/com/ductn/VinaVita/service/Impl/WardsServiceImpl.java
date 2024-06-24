/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service.Impl;

import com.ductn.VinaVita.models.Districts;
import com.ductn.VinaVita.models.Wards;
import com.ductn.VinaVita.repository.DistrictsRepository;
import com.ductn.VinaVita.repository.WardsRepository;
import com.ductn.VinaVita.service.WardsService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */

@Service
public class WardsServiceImpl implements WardsService {
    
    @Autowired
    private WardsRepository wardsRepository;
    
    @Autowired
    private DistrictsRepository districtsRepository;

    @Override
    public List<Wards> findWardsByDistrictCode(String districtCode) {
        Districts districts = this.districtsRepository.findById(districtCode).get();
        return this.wardsRepository.findWardsByDistrictCode(districts);
    }
    
}
