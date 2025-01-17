/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.models.MedicalReminder;

import java.util.List;
import java.util.Optional;

import com.ductn.VinaVita.models.MedicalSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author Administrator
 */
public interface MedicalScheduleService {

    Optional<MedicalSchedule> findByMedicalScheduleIdAndActiveTrue(Integer medicalScheduleId);

    List<MedicalSchedule> findByMedicalReminderIdAndActiveTrue(MedicalReminder medicalReminderId);

    Page<?> findAllMedicalSchedulePageSpec(Specification<?> createSpecification, Pageable page);

    List<?> findMedicalScheduleByPrescriptionId(int prescriptionId);

    MedicalSchedule addMedicalSchedule(MedicalSchedule medicalSchedule);

    MedicalSchedule updateMedicalSchedule(MedicalSchedule medicalSchedule);

    void deleteAllMedicalScheduleInBatch(List<MedicalSchedule> medicalSchedules);

    void hardDeleteMedicalSchedule(MedicalSchedule medicalSchedule);
}
