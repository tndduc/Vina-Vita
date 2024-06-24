package com.ductn.VinaVita.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMedicalScheduleDTO {

    private String medicalReminderId;
    private String customTime;
    private String startDate;
    private String medicineName;
    private String email;
    private String userId;
}
