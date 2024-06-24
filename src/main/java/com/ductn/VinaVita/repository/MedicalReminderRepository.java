/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.repository;

import com.ductn.VinaVita.models.MedicalReminder;
import com.ductn.VinaVita.models.PrescriptionDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Administrator
 */
@Repository
@Transactional
public interface MedicalReminderRepository extends JpaRepository<MedicalReminder, Integer> {

    List<MedicalReminder> findByPrescriptionDetailId(PrescriptionDetail prescriptionDetailId);

    @Query("SELECT mr "
            + "FROM MedicalReminder mr "
            + "JOIN mr.prescriptionDetailId pd "
            + "JOIN pd.prescriptionId p "
            + "WHERE p.prescriptionId = :prescriptionId")
    List<?> findMedicalReminderByPrescriptionId(@Param("prescriptionId") int prescriptionId);

    Optional<MedicalReminder> findByMedicalReminderId(Integer medicalReminderId);
}
