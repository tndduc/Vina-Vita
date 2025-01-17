/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.dto;

import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Getter
@Setter
public class AddPrescriptionDetailDTO {

    @NotBlank
    private String medicineId;

    @NotBlank
    private String medicineName;

    @NotBlank
    private String unitPrice;

    @NotBlank
    private String usageInstruction;

    @NotBlank
    private String quantity;

    private Map<String, AddMedicalReminderDTO> medicalReminderDTO;

}
