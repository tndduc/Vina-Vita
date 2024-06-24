/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.dto.AddPrescriptionDTO;
import com.ductn.VinaVita.dto.AddPrescriptionDetailDTO;
import com.ductn.VinaVita.dto.UpdatePrescriptionDTO;
import com.ductn.VinaVita.models.Booking;
import com.ductn.VinaVita.models.Prescriptions;

import jakarta.persistence.NonUniqueResultException;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;

/**
 *
 * @author Administrator
 */
public interface PrescriptionService {

        int addPrescription(AddPrescriptionDTO addPrescriptionDTO,
                            Map<String, AddPrescriptionDetailDTO> prescriptionDetailDTO);

        Page<Prescriptions> findAllPrescriptionPageSpec(Map<String, String> params);

        Page<Prescriptions> getPrescriptionsByProfilePatientIdPageSpec(Map<String, String> params);

        int payMedicine(int prescriptionId, String medicine_payment_TxnRef);

        int payService(int prescriptionId, String service_payment_TxnRef);

        Optional<Prescriptions> findByBookingId(Booking bookingId) throws NonUniqueResultException;

        int updatePrescription(UpdatePrescriptionDTO updatePrescriptionDTO,
                               Map<String, AddPrescriptionDetailDTO> prescriptionDetailDTO);
}
