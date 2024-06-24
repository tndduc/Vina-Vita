/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.dto.AddMedicineDTO;
import com.ductn.VinaVita.dto.UpdateMedicineDTO;

import java.util.List;
import java.util.Map;

import com.ductn.VinaVita.models.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */
public interface MedicineService {

    List<Medicine> findMedicineByActiveTrue();

    Medicine findMedicineByMedicineIdAndActiveTrue(int medicineId);

    List<Medicine> findMedicineByCategoryId(int medicineCategoryId);

    int addMedicine(AddMedicineDTO addMedicineDTO, MultipartFile avatar);

    int updateMedicine(UpdateMedicineDTO updateMedicineDTO, MultipartFile avatar);

    Page<Medicine> findAllMedicinePageSpec(Map<String, String> params);

    List<Medicine> findAllMedicineSpec(Map<String, String> params);
}
