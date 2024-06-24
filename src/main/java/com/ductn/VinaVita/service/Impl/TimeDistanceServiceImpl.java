/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service.Impl;

import com.ductn.VinaVita.models.TimeDistance;
import com.ductn.VinaVita.repository.TimeDistanceRepository;
import com.ductn.VinaVita.service.TimeDistanceService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class TimeDistanceServiceImpl implements TimeDistanceService {

    @Autowired
    private TimeDistanceRepository timeDistanceRepository;

    @Override
    public List<TimeDistance> findTimeDistanceByActiveTrue() {
        return this.timeDistanceRepository.findTimeDistanceByActiveTrue();
    }

}
