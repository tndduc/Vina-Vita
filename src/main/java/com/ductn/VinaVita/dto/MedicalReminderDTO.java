package com.ductn.VinaVita.dto;

import com.ductn.VinaVita.models.TimeReminder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalReminderDTO {
    private String medicalReminderId;
    private String prescriptionDetailId;
    private TimeReminder timeReminderId;
}
