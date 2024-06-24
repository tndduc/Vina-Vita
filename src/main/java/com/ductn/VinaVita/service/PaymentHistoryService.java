/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import java.util.Optional;

import com.ductn.VinaVita.models.Booking;
import com.ductn.VinaVita.models.PaymentHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Administrator
 */
public interface PaymentHistoryService {
        Page<?> findPaymentHistoryByProfilePatientId(int profilePatientId, Pageable page);

        PaymentHistory addPaymentHistory(PaymentHistory paymentHistory, Booking booking);

        Optional<PaymentHistory> findByPaymentHistoryId(Integer paymentHistoryId);
}
