/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import java.util.Map;
import java.util.Optional;

import com.ductn.VinaVita.models.Notification;
import com.ductn.VinaVita.models.User;
import org.springframework.data.domain.Page;

/**
 *
 * @author Administrator
 */
public interface NotificationService {
    Notification addNotification(Notification notification);

    Page<Notification> findNotificationByReceiverIdAndActiveTrue(User receiverId, Map<String, String> params);

    Notification seenNotification(Notification notification);

    Optional<Notification> findNotificationByNotificationIdAndActiveTrue(int notificationId);
}
