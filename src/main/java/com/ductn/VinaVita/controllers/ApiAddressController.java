/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.controllers;

import com.ductn.VinaVita.models.Districts;
import com.ductn.VinaVita.models.Provinces;
import com.ductn.VinaVita.models.Wards;
import com.ductn.VinaVita.service.DistrictsService;
import com.ductn.VinaVita.service.ProvincesService;
import com.ductn.VinaVita.service.WardsService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class ApiAddressController {

    @Autowired
    private ProvincesService provincesService;

    @Autowired
    private DistrictsService districtsService;
    
    @Autowired
    private WardsService wardsService;

    @GetMapping("/public/provinces/")
    @CrossOrigin
    public ResponseEntity<List<Provinces>> listProvinces() {
        return ResponseEntity.ok().body(this.provincesService.findAllProvinces());
    }

    @GetMapping("/public/provinces/{provinceCode}/districts/")
    @CrossOrigin
    public ResponseEntity<List<Districts>> listDistrictsByProvincesCode(@PathVariable(value = "provinceCode") String provinceCode) {
        return ResponseEntity.ok().body(this.districtsService.findDistrictsByProvinceCode(provinceCode));
    }
    
    @GetMapping("/public/districts/{districtCode}/wards/")
    @CrossOrigin
    public ResponseEntity<List<Wards>> listWardsByDistrictsCode(@PathVariable(value = "districtCode") String districtCode) {
        return ResponseEntity.ok().body(this.wardsService.findWardsByDistrictCode(districtCode));
    }
}
