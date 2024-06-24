package com.ductn.VinaVita.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddChatgptConsultDTO {
    private String patientQuestion;
    @NotBlank
    private String userId;
    private String chatgptQuestionId;
}
