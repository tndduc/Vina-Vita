package com.ductn.VinaVita.dto;

import java.util.List;

import com.ductn.VinaVita.models.PrescriptionDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrescriptionDetailReminderDTO {
    PrescriptionDetail prescriptionDetail;
    List<MedicalReminderDTO> timeReminders;
    // List<MedicalReminder> timeReminders;
}
