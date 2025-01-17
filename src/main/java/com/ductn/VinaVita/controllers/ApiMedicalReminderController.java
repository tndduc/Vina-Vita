/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.controllers;

import com.ductn.VinaVita.service.MedicalReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class ApiMedicalReminderController {

    @Autowired
    private MedicalReminderService medicalReminderService;

    @GetMapping("/auth/prescriptionId/{prescriptionId}/medical-reminder/")
    @CrossOrigin
    public ResponseEntity<?> listMedicalReminder(
            @PathVariable(value = "prescriptionId") int prescriptionId) {
        return ResponseEntity.ok()
                .body(this.medicalReminderService.findMedicalReminderByPrescriptionId(prescriptionId));
    }
}
