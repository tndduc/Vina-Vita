/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.dto.AddMedicineCategoryDTO;
import com.ductn.VinaVita.dto.UpdateMedicineCategoryDTO;

import java.util.List;
import java.util.Map;

import com.ductn.VinaVita.models.MedicineCategory;
import org.springframework.data.domain.Page;

/**
 *
 * @author Administrator
 */
public interface MedicineCategoryService {

    List<MedicineCategory> findMedicineCategoryByActiveTrue();

    MedicineCategory findMedicineCategoryByCategoryIdAndActiveTrue(int medicineCategoryId);

    int addMedicineCategory(AddMedicineCategoryDTO addMedicineCategoryDTO);

    int updateMedicineCategory(UpdateMedicineCategoryDTO updateMedicineCategoryDTO);

    Page<MedicineCategory> findAllMedicineCategoryPageSpec(Map<String, String> params);
}
