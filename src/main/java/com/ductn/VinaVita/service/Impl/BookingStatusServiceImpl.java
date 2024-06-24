/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service.Impl;

import com.ductn.VinaVita.models.BookingStatus;
import com.ductn.VinaVita.repository.BookingStatusRepository;
import com.ductn.VinaVita.service.BookingStatusService;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class BookingStatusServiceImpl implements BookingStatusService {

    @Autowired
    private BookingStatusRepository bookingStatusRepository;

    @Override
    public BookingStatus findBookingStatusByStatusId(int bookingStatusId) {
        try {
            Optional<BookingStatus> bookingStatusOptional = this.bookingStatusRepository
                    .findBookingStatusByStatusId(bookingStatusId);
            if (bookingStatusOptional.isPresent()) {
                return bookingStatusOptional.get();
            } else {
                return null;
            }

        } catch (NoSuchElementException ex) {
            return null;
        }

    }

}
