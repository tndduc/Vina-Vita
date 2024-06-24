/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service.Impl;

import com.ductn.VinaVita.models.PrescriptionDetail;
import com.ductn.VinaVita.models.Prescriptions;
import com.ductn.VinaVita.repository.PrescriptionDetailRepository;
import com.ductn.VinaVita.repository.PrescriptionRepository;
import com.ductn.VinaVita.service.PrescriptionDetailService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class PrescriptionDetailServiceImpl implements PrescriptionDetailService {

    @Autowired
    private PrescriptionDetailRepository prescriptionDetailRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public List<PrescriptionDetail> findPrescriptionDetailByPrescriptionId(int prescriptionId) {
        // Specification<Prescriptions> specPrescriptions =
        // GenericSpecifications.fieldEquals("active", Boolean.TRUE);
        Optional<Prescriptions> prescriptionOptional = this.prescriptionRepository.findById(prescriptionId);

        if (prescriptionOptional.isPresent()) {
            return this.prescriptionDetailRepository.findPrescriptionDetailByPrescriptionId(prescriptionOptional.get());
        }

        return new ArrayList<>();
    }

    @Override
    public Optional<PrescriptionDetail> findPrescriptionDetailByPrescriptionDetailIdAndActiveTrue(
            int prescriptionDetailId) {
        return this.prescriptionDetailRepository
                .findPrescriptionDetailByPrescriptionDetailIdAndActiveTrue(prescriptionDetailId);
    }

}
