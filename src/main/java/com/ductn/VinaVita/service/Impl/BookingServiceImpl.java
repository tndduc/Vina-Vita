/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service.Impl;

import com.ductn.VinaVita.components.datetime.DateFormatComponent;
import com.ductn.VinaVita.dto.BookingDTO;
import com.ductn.VinaVita.models.*;
import com.ductn.VinaVita.repository.*;
import com.ductn.VinaVita.service.BookingService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ProfilePatientRepository profilePatientRepository;

    @Autowired
    private BookingStatusRepository bookingStatusRepository;

    @Autowired
    private DateFormatComponent dateFormatComponent;

    @Autowired
    private Environment environment;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addBooking(BookingDTO bookingDTO) {
        try {
            Booking booking = new Booking();
            Optional<Schedule> scheduleOptional = this.scheduleRepository
                    .findScheduleByScheduleIdAndActiveTrue(Integer.parseInt(bookingDTO.getScheduleId()));

            if (scheduleOptional.isPresent()) {
                Schedule schedule = scheduleOptional.get();
                booking.setScheduleId(schedule);

                schedule.setBooked(Boolean.TRUE);
                this.scheduleRepository.save(schedule);
            } else {
                return 0;
            }

            Optional<ProfilePatient> profilePatientOptional = this.profilePatientRepository
                    .findProfilePatientByProfilePatientIdAndActiveTrue(
                            Integer.parseInt(bookingDTO.getProfilePatientId()));

            if (profilePatientOptional.isPresent()) {
                booking.setProfilePatientId(profilePatientOptional.get());
            } else {
                return 0;
            }

            booking.setStatusId(this.bookingStatusRepository.findBookingStatusByStatusId(1).get());
            booking.setCreatedDate(new Date());

            booking.setBookingCancel(Boolean.FALSE);
            booking.setActive(Boolean.TRUE);
            this.bookingRepository.save(booking);
            return 1;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return 0;
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int cancelBooking(int bookingId) {
        try {
            Optional<Booking> bookingOptional = this.bookingRepository.findBookingByBookingIdAndActiveTrue(bookingId);

            if (bookingOptional.isPresent()) {
                Booking booking = bookingOptional.get();

                Optional<Schedule> scheduleOptional = this.scheduleRepository
                        .findScheduleByScheduleIdAndActiveTrue(booking.getScheduleId().getScheduleId());

                if (scheduleOptional.isPresent()) {
                    Schedule schedule = scheduleOptional.get();
                    schedule.setBooked(Boolean.FALSE);
                    this.scheduleRepository.save(schedule);
                } else {
                    return 0;
                }

                booking.setBookingCancel(Boolean.TRUE);
                booking.setUpdatedDate(new Date());
                this.bookingRepository.save(booking);
                return 1;
            }
            return 0;
        } catch (NoSuchElementException ex) {
            Logger.getLogger(BookingServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    @Override
    public int acceptBooking(int bookingId) {
        try {
            Optional<Booking> bookingOptional = this.bookingRepository.findBookingByBookingIdAndActiveTrue(bookingId);

            if (bookingOptional.isPresent()) {
                Booking booking = bookingOptional.get();
                booking.setStatusId(new BookingStatus(2));
                booking.setUpdatedDate(new Date());
                this.bookingRepository.save(booking);
                return 1;
            } else {
                return 0;
            }

        } catch (NoSuchElementException ex) {
            Logger.getLogger(BookingServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int denyBooking(int bookingId) {
        try {
            Optional<Booking> bookingOptional = this.bookingRepository.findBookingByBookingIdAndActiveTrue(bookingId);

            if (bookingOptional.isPresent()) {
                Booking booking = bookingOptional.get();
                booking.setStatusId(new BookingStatus(3));
                booking.setUpdatedDate(new Date());
                this.bookingRepository.save(booking);
                return 1;
            }
            return 0;
        } catch (NoSuchElementException ex) {
            Logger.getLogger(BookingServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    // @Override
    // public List<Booking> findBookingForUserView(int userId) {
    // Specification<Booking> specification = (root, query, criteriaBuilder) -> {
    // Join<Booking, ProfilePatient> profilePatientJoin =
    // root.join("profilePatient");
    //
    // Join<ProfilePatient, User> userJoin = profilePatientJoin.join("user");
    //
    // return criteriaBuilder.equal(userJoin.get("userId"), userId);
    // };
    //
    // return this.joinBookingRepository.findBookingForUserView(specification);
    // }
    @Override
    public List<Object[]> getBookingForUserView(int userId) {
        return this.bookingRepository.getBookingForUserViewList(userId);
    }

    @Override
    public List<Object[]> getTimeSlotsForDoctorOnDate(int profileDoctorId, String date) {
        try {
            Date date_parse = this.dateFormatComponent.myDateFormat().parse(date);
            return this.bookingRepository.getTimeSlotsForDoctorOnDate(profileDoctorId, date_parse);
        } catch (ParseException ex) {
            Logger.getLogger(BookingServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    @Override
    public List<?> getDatesForProfileDoctor(int profileDoctorId) {
        return this.bookingRepository.getDatesForProfileDoctor(profileDoctorId);
    }

    @Override
    public List<Object[]> getBookingForDoctorView(int profileDoctorId) {
        return this.bookingRepository.getBookingForDoctorView(profileDoctorId);
    }

    @Override
    public List<Object[]> getBookingDetailsByBookingId(int bookingId) {
        return this.bookingRepository.getBookingDetailsByBookingId(bookingId);
    }

    @Override
    @Transactional
    public int softDeleteBooking(int bookingId) {
        Optional<Booking> bookingOptional = this.bookingRepository.findBookingByBookingIdAndActiveTrue(bookingId);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            if (booking.getActive().equals(Boolean.TRUE)) {
                booking.setActive(Boolean.FALSE);
                return 1;
            } else {
                System.out.println("Booking: " + booking.getActive());
                return 2;
            }
        } else {
            return 3; // Không tìm được để xóa
        }
    }

    @Override
    public Page<?> getBookingForDoctorViewPage(int profileDoctorId, int bookingStatusId,
            Map<String, String> params) {
        String pageNumber = params.get("pageNumber");

        int defaultPageNumber = 0;
        Sort mySort = Sort.by("createdDate").descending();
        Pageable page = PageRequest.of(defaultPageNumber,
                Integer.parseInt(this.environment.getProperty("spring.data.web.pageable.default-page-size")), mySort);
        if (pageNumber != null && !pageNumber.isEmpty()) {
            if (!pageNumber.equals("NaN")) {
                page = PageRequest.of(Integer.parseInt(pageNumber),
                        Integer.parseInt(this.environment.getProperty("spring.data.web.pageable.default-page-size")),
                        mySort);
            }
        }
        return this.bookingRepository.getBookingForDoctorViewPage(profileDoctorId, bookingStatusId, page);

    }

    @Override
    public Booking cancelBooking(Booking booking) {
        return this.bookingRepository.save(booking);
    }

    @Override
    public Booking acceptBooking(Booking booking) {
        return this.bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> findBookingByBookingIdAndActiveTrue(int bookingId) {
        return this.bookingRepository.findBookingByBookingIdAndActiveTrue(bookingId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Booking createBooking(Booking booking, Schedule schedule, ProfilePatient profilePatient) {
        this.scheduleRepository.save(schedule);
        this.profilePatientRepository.save(profilePatient);
        return this.bookingRepository.save(booking);
    }

    @Override
    public Page<?> getBookingForUserView(int userId, int bookingStatusId, Pageable page) {
        return this.bookingRepository.getBookingForUserView(userId, bookingStatusId, page);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Booking createBookingReExamination(TimeSlot timeSlot, Booking booking, Schedule schedule,
                                              ProfilePatient profilePatient) {

        TimeSlot timeSlotSaved = this.timeSlotRepository.save(timeSlot);
        schedule.setTimeSlotId(timeSlotSaved);

        Schedule scheduleSaved = this.scheduleRepository.save(schedule);
        booking.setScheduleId(scheduleSaved);

        /*
         * Lưu lại ProfilePatient cái field isLock
         * Thực ra nó đã lock = true rồi nhưng save lần nữa cho an tâm
         */
        this.profilePatientRepository.save(profilePatient);

        Booking bookingSaved = this.bookingRepository.save(booking);

        /*
         * Sẽ có trường hợp tới khám nhưng không kê toa thuốc vì lý do gì đó
         * mà bác sĩ sẽ hẹn lần sau tới khám thì sao?
         * 
         * Nếu chưa tạo toa thuốc (tức là chưa khám xong)
         * mà tạo lịch tái khám thì chỗ này tạm thời xử lý như đoạn code bên dưới
         */

        Optional<Prescriptions> prescriptionOptional = this.prescriptionRepository.findByBookingId(bookingSaved);
        if (prescriptionOptional.isPresent()) {
            Prescriptions prescription = prescriptionOptional.get();
            prescription.setReExaminationDate(timeSlotSaved.getTimeBegin());
        }

        return bookingSaved;
    }

    @Override
    public Page<?> getBookingForUserViewDoubleStatus(int userId, int bookingStatusId1, int bookingStatusId2,
            Pageable page) {
        return this.bookingRepository.getBookingForUserViewDoubleStatus(userId, bookingStatusId1, bookingStatusId2,
                page);
    }

}
