/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.models.PrescriptionDetail;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Administrator
 */
public interface PrescriptionDetailService {

    List<PrescriptionDetail> findPrescriptionDetailByPrescriptionId(int prescriptionId);

    Optional<PrescriptionDetail> findPrescriptionDetailByPrescriptionDetailIdAndActiveTrue(int prescriptionDetailId);
}
