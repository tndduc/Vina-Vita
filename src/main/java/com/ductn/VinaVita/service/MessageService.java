/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.dto.AddMessageDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ductn.VinaVita.models.Message;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */
public interface MessageService {

    Page<Message> getMessagesBetweenUsersAndProfileDoctors(Map<String, String> params);

    Page<Message> findMessagesByUserIdAndProfileDoctorIdPage(int userId, int profileDoctorId,
                                                             Map<String, String> params);

    List<Message> findMessagesByUserIdAndProfileDoctorId(int userId, int profileDoctorId);

    int addMessage(AddMessageDTO addMessageDTO, MultipartFile avatar);

    Page<?> getAllUsersByProfileDoctorMessaging(int profileDoctorId, Map<String, String> params);

    Message addMessage(Message message, MultipartFile avatar);

    Optional<Message> findMessageByMessageIdAndActiveTrue(int messageId);

    Message seenMessage(Message message);

    Page<?> getMessageProfileDoctorByUserIdPage(int userId, Map<String, String> params);
}
