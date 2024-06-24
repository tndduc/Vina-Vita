package com.ductn.VinaVita.repository;


import com.ductn.VinaVita.models.Districts;
import com.ductn.VinaVita.models.Wards;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
@Repository
@Transactional
public interface WardsRepository extends JpaRepository<Wards, String>{
    List<Wards> findWardsByDistrictCode(Districts districtCode);
}
