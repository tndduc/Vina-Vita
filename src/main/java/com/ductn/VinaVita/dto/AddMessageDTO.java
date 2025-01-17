/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author Administrator
 */

@Data
public class AddMessageDTO {

    @NotBlank
    private String userId;

    @NotBlank
    private String profileDoctorId;

    @NotBlank
    private String senderId;

    @NotBlank
    private String messageContent;

    // @NotBlank
    private MultipartFile avatar;
}
