/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Getter
@Setter
public class AddCommentDTO {

    @NotBlank
    private String profileDoctorId;

    @NotBlank
    private String userId;
    
    @NotBlank
    private String content;
    
    @NotBlank
    private String rating;
}
