/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.repository;

import java.util.Optional;

import com.ductn.VinaVita.models.PaymentHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Repository
@Transactional
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Integer> {
    Optional<PaymentHistory> findByPaymentHistoryId(Integer paymentHistoryId);

    @Query("SELECT ph "
            + "FROM PaymentHistory ph "
            + "JOIN ph.bookingId b "
            + "JOIN b.profilePatientId pp "
            + "WHERE pp.profilePatientId = :profilePatientId")
    Page<?> findPaymentHistoryByProfilePatientId(@Param("profilePatientId") int profilePatientId, Pageable page);

}
