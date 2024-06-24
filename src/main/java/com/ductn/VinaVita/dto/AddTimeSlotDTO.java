package com.ductn.VinaVita.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTimeSlotDTO {
    @NotBlank
    String timeBegin;
    @NotBlank
    String timeEnd;
    @NotBlank
    String note;
    @NotBlank
    String profileDoctorId;
}
