/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service.Impl;

import com.ductn.VinaVita.components.datetime.DateFormatComponent;
import com.ductn.VinaVita.dto.AddScheduleDTO;
import com.ductn.VinaVita.models.ProfileDoctor;
import com.ductn.VinaVita.models.Schedule;
import com.ductn.VinaVita.models.TimeSlot;
import com.ductn.VinaVita.repository.ProfileDoctorRepository;
import com.ductn.VinaVita.repository.ScheduleRepository;
import com.ductn.VinaVita.repository.TimeSlotRepository;
import com.ductn.VinaVita.service.ScheduleService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ProfileDoctorRepository profileDoctorRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    DateFormatComponent dateFormatComponent;

    @Override
    public int addSchedule(AddScheduleDTO addScheduleDTO) {
        try {
            Schedule schedule = new Schedule();
            schedule.setProfileDoctorId(this.profileDoctorRepository.findProfileDoctorByProfileDoctorIdAndActiveTrue(
                    Integer.parseInt(addScheduleDTO.getProfileDoctorId())).get());
            schedule.setDate(this.dateFormatComponent.myDateFormat().parse(addScheduleDTO.getDate()));
            schedule.setTimeSlotId(this.timeSlotRepository
                    .findTimeSlotByTimeSlotIdAndActiveTrue(Integer.parseInt(addScheduleDTO.getTimeSlotId())).get());
            schedule.setCreatedDate(new Date());
            schedule.setActive(Boolean.TRUE);
            schedule.setBooked(Boolean.FALSE);

            this.scheduleRepository.save(schedule);
            return 1;
        } catch (ParseException ex) {
            Logger.getLogger(ScheduleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int addCustomSchedule(List<AddScheduleDTO> addScheduleDTOList) {

        for (AddScheduleDTO addScheduleDTO : addScheduleDTOList) {
            this.addSchedule(addScheduleDTO);
        }

        return 1;
    }

    @Override
    public Schedule findScheduleByIdAndActiveTrue(int scheduleId) {
        return this.scheduleRepository.findScheduleByScheduleIdAndActiveTrue(scheduleId).get();
    }

    @Override
    public Optional<Schedule> findScheduleByIdAndActiveTrueOptional(int scheduleId) {
        return this.scheduleRepository.findScheduleByScheduleIdAndActiveTrue(scheduleId);
    }

    @Override
    public Schedule findScheduleByProfileDoctorIdAndDateAndTimeSlotIdAndActiveTrue(int profiledoctorId, String date,
                                                                                   int timeSlotId) {

        try {
            Optional<ProfileDoctor> profileDoctorOptional = this.profileDoctorRepository
                    .findProfileDoctorByProfileDoctorIdAndActiveTrue(profiledoctorId);
            Optional<TimeSlot> timeSlotOptional = this.timeSlotRepository
                    .findTimeSlotByTimeSlotIdAndActiveTrue(timeSlotId);
            Date date_parse = this.dateFormatComponent.myDateFormat().parse(date);

            if (!profileDoctorOptional.isPresent()) {
                return null;
            }

            if (!timeSlotOptional.isPresent()) {
                return null;
            }

            Optional<Schedule> scheduleOptional = this.scheduleRepository
                    .findScheduleByProfileDoctorIdAndDateAndTimeSlotIdAndActiveTrue(profileDoctorOptional.get(),
                            date_parse, timeSlotOptional.get());
            if (scheduleOptional.isPresent()) {
                return scheduleOptional.get();
            } else {
                return null;
            }

        } catch (ParseException ex) {
            Logger.getLogger(ScheduleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchElementException ex) {
            Logger.getLogger(ScheduleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int isScheduleExists(int profiledoctorId, String date, int timeSlotId) {

        try {
            Optional<ProfileDoctor> profileDoctorOptional = this.profileDoctorRepository
                    .findProfileDoctorByProfileDoctorIdAndActiveTrue(profiledoctorId);
            Optional<TimeSlot> timeSlotOptional = this.timeSlotRepository
                    .findTimeSlotByTimeSlotIdAndActiveTrue(timeSlotId);
            Date date_parse = this.dateFormatComponent.myDateFormat().parse(date);

            if (!profileDoctorOptional.isPresent()) {
                return 2;
            }

            if (!timeSlotOptional.isPresent()) {
                return 2;
            }

            Optional<Schedule> scheduleOptional = this.scheduleRepository
                    .findScheduleByProfileDoctorIdAndDateAndTimeSlotIdAndActiveTrue(profileDoctorOptional.get(),
                            date_parse, timeSlotOptional.get());
            if (scheduleOptional.isPresent()) {
                return 1;
            } else {
                return 0;
            }

        } catch (ParseException ex) {
            Logger.getLogger(ScheduleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 2;
        } catch (NoSuchElementException ex) {
            Logger.getLogger(ScheduleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 2;
        }
    }

    @Override
    @Transactional
    public int softDeleteSchedule(int scheduleId) {
        Optional<Schedule> scheduleOptional = this.scheduleRepository.findScheduleByScheduleIdAndActiveTrue(scheduleId);
        if (scheduleOptional.isPresent()) {
            Schedule schedule = scheduleOptional.get();
            if (schedule.getActive().equals(Boolean.TRUE)) {
                schedule.setActive(Boolean.FALSE);
                return 1;
            } else {
                System.out.println("Schedule: " + schedule.getActive());
                return 2;
            }
        } else {
            return 3; // Không tìm được để xóa
        }
    }

    @Override
    public List<Schedule> findScheduleByProfileDoctorIdAndActiveTrue(int profiledoctorId) {
        Optional<ProfileDoctor> profileDoctorOptional = this.profileDoctorRepository
                .findProfileDoctorByProfileDoctorIdAndActiveTrue(profiledoctorId);
        if (profileDoctorOptional.isPresent()) {
            return this.scheduleRepository.findScheduleByProfileDoctorIdAndActiveTrue(profileDoctorOptional.get());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Schedule addSchedule(TimeSlot timeSlot, Date date, ProfileDoctor profileDoctor) {
        Schedule schedule = new Schedule();
        schedule.setTimeSlotId(timeSlot);
        schedule.setDate(date);
        schedule.setProfileDoctorId(profileDoctor);
        schedule.setCreatedDate(new Date());
        schedule.setActive(Boolean.TRUE);
        schedule.setBooked(Boolean.FALSE);

        return this.scheduleRepository.save(schedule);
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) {
        return this.scheduleRepository.save(schedule);
    }

    @Override
    public Schedule addSchedule(Schedule schedule) {
        return this.scheduleRepository.save(schedule);
    }

}
