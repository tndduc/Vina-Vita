/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.repository;

import com.ductn.VinaVita.models.ProfileDoctor;
import com.ductn.VinaVita.models.TimeDistance;
import com.ductn.VinaVita.models.TimeSlot;

import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Repository
@Transactional
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer> {

    List<TimeSlot> findTimeSlotByTimeDistanceIdAndActiveTrue(TimeDistance timeDistanceId);

    Optional<TimeSlot> findTimeSlotByTimeSlotIdAndActiveTrue(int timeSlotId);

    List<?> findTimeSlotsByProfileDoctorIdOrderByTimeBeginAsc(
            @Param("profileDoctor") ProfileDoctor profileDoctor);

    List<?> findTimeSlotsByProfileDoctorIdOrderByTimeBeginDesc(
            @Param("profileDoctor") ProfileDoctor profileDoctor);
}
