/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.models.ProfileDoctor;
import com.ductn.VinaVita.models.Schedule;
import com.ductn.VinaVita.models.TimeSlot;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Administrator
 */
public interface TimeSlotService {
    List<TimeSlot> findTimeSlotByTimeDistanceIdAndActiveTrue(int timeDistanceId);

    List<?> getTimeSlotByTimeDistanceIdWithCheckRegister(int timeDistanceId, int profiledoctorId, String date);

    TimeSlot addTimeSlot(Date timeBegin, Date timeEnd, String note, ProfileDoctor profileDoctor);

    TimeSlot updateTimeSlot(TimeSlot timeSlot);

    Optional<TimeSlot> findTimeSlotByTimeSlotIdAndActiveTrue(int timeDistanceId);

    Schedule addTimeSlotAndSchedule(Date timeBegin, Date timeEnd, String note, ProfileDoctor profileDoctor);

    Schedule updateTimeSlotAndSchedule(TimeSlot timeSlot, String dateSchedule) throws NullPointerException;

    List<?> findTimeSlotsByProfileDoctorIdOrderByTimeBeginAsc(ProfileDoctor profileDoctor);

    List<?> findTimeSlotsByProfileDoctorIdOrderByTimeBeginDesc(ProfileDoctor profileDoctor);
}
