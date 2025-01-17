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
public class AddNotificationDTO {

    @NotBlank
    String senderId;

    @NotBlank
    String receiverId;

    // @NotBlank
    String profileDoctorId;

    @NotBlank
    String notificationTypeId;

    @NotBlank
    String notificationContent;

}
