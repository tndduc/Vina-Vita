package com.ductn.VinaVita.dto;

import com.ductn.VinaVita.models.Schedule;
import com.ductn.VinaVita.models.TimeSlot;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Getter
@Setter
public class AddTimeSlotAndScheduleDTO {

    @NotBlank
    private TimeSlot timeSlot;
    @NotBlank
    private Schedule schedule;
}