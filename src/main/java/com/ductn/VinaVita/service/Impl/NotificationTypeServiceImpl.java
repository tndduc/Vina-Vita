/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service.Impl;

import com.ductn.VinaVita.models.NotificationType;
import com.ductn.VinaVita.repository.NotificationTypeRepository;
import com.ductn.VinaVita.service.NotificationTypeService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class NotificationTypeServiceImpl implements NotificationTypeService {

    @Autowired
    private NotificationTypeRepository notificationTypeRepository;

    @Override
    public Optional<NotificationType> findNotificationTypeByNotificationTypeIdAndActiveTrue(int notificationId) {
        return this.notificationTypeRepository.findNotificationTypeByNotificationTypeIdAndActiveTrue(notificationId);
    }

}
