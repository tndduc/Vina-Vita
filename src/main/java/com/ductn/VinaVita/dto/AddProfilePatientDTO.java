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
public class AddProfilePatientDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String phonenumber;
    private Boolean gender;
    @NotBlank
    private String birthday;
    @NotBlank
    private String provinceName;
    @NotBlank
    private String districtName;
    @NotBlank
    private String wardName;
    @NotBlank
    private String personalAddress;
//    @NotBlank
//    String address;
    @NotBlank
    private String email;
    @NotBlank
    private String relationship;
    @NotBlank
    private String userId;
}
