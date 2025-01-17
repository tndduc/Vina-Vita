/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.repository;

import com.ductn.VinaVita.models.Notification;

import java.util.Optional;

import com.ductn.VinaVita.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Repository
@Transactional
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    Optional<Notification> findNotificationByNotificationIdAndActiveTrue(int notificationId);

    // Lấy toàn bộ thông báo có id người nhận là user đang login
    // @OrderBy("createdDate DESC")
    Page<Notification> findNotificationByReceiverIdAndActiveTrueOrderByCreatedDateDesc(User receiverId, Pageable page);
}
