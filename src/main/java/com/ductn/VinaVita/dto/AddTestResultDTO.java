package com.ductn.VinaVita.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTestResultDTO {

    @NotBlank
    private String testServiceId;

    @NotBlank
    private String bookingId;

}
