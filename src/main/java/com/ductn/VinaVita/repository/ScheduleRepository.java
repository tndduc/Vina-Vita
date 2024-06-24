/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.repository;

import com.ductn.VinaVita.models.ProfileDoctor;
import com.ductn.VinaVita.models.Schedule;
import com.ductn.VinaVita.models.TimeSlot;

import java.util.Date;
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
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    Optional<Schedule> findScheduleByScheduleIdAndActiveTrue(int scheduleId);
    Optional<Schedule> findScheduleByProfileDoctorIdAndDateAndTimeSlotIdAndActiveTrue(ProfileDoctor profiledoctorId, Date date, TimeSlot timeSlotId);
    List<Schedule> findScheduleByProfileDoctorIdAndActiveTrue(ProfileDoctor profiledoctorId);
}
