/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrator
 */

@Getter
@Setter
public class ChatGPTRequestDTO {
    private String model;
    private List<ChatGPTMessageDTO> messages;
}
