/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.models.BookingStatus;

/**
 *
 * @author Administrator
 */

public interface BookingStatusService {
    BookingStatus findBookingStatusByStatusId(int bookingStatusId);
}
