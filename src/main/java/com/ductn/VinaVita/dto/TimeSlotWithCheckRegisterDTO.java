package com.ductn.VinaVita.dto;

import com.ductn.VinaVita.models.TimeSlot;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TimeSlotWithCheckRegisterDTO {
    @NotBlank
    private TimeSlot timeSlot;
    @NotBlank
    private Boolean isRegister;
}
