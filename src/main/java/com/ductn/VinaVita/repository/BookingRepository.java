/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.repository;

import com.ductn.VinaVita.models.Booking;
import com.ductn.VinaVita.models.ProfilePatient;

import java.util.Date;
import java.util.List;
import java.util.Optional;
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
public interface BookingRepository extends JpaRepository<Booking, Integer> {

        Optional<Booking> findBookingByBookingIdAndActiveTrue(int bookingId);

        Optional<Booking> findBookingByActiveTrueAndBookingCancelFalse();

        // User view
        List<Booking> findBookingByProfilePatientIdAndActiveTrue(ProfilePatient profilePatientId);

        // Optional<Booking> findBookingByProfilePatientIdAndActiveTrue(ProfilePatient
        // profilePatientId);
        // @Query(value = "SELECT u.user_id, u.firstname, pp.name,
        // pp.profile_patient_id, pd.name, pp.name, b.created_date"
        // + "FROM booking b, profile_doctor pd, profile_patient pp, schedule s, user u
        // "
        // + "WHERE b.profile_patient_id = pp.profile_patient_id "
        // + "AND b.schedule_id = s.schedule_id "
        // + "AND s.profile_doctor_id = pd.profile_doctor_id "
        // + "AND u.user_id = pp.user_id "
        // + "AND u.user_id = :userId", nativeQuery = true)
        @Query("SELECT u.userId, u.firstname, pp.name, pp.profilePatientId, pd.name, pp.name, b.createdDate, b.bookingCancel, b.bookingId "
                        + "FROM Booking b JOIN b.profilePatientId pp JOIN b.scheduleId s JOIN s.profileDoctorId pd JOIN pp.userId u "
                        + "WHERE u.userId = :userId")
        List<Object[]> getBookingForUserViewList(@Param("userId") int userId);

        @Query("SELECT b "
                        + "FROM Booking b JOIN b.profilePatientId pp JOIN b.scheduleId s JOIN s.profileDoctorId pd JOIN pp.userId u "
                        + "WHERE u.userId = :userId AND b.statusId.statusId = :bookingStatusId ")
        Page<?> getBookingForUserView(@Param("userId") int userId, @Param("bookingStatusId") int bookingStatusId,
                        Pageable page);

        @Query("SELECT b "
                        + "FROM Booking b JOIN b.profilePatientId pp JOIN b.scheduleId s JOIN s.profileDoctorId pd JOIN pp.userId u "
                        + "WHERE u.userId = :userId AND (b.statusId.statusId = :bookingStatusId1 OR b.statusId.statusId = :bookingStatusId2)")
        Page<Booking> getBookingForUserViewDoubleStatus(
                        @Param("userId") int userId,
                        @Param("bookingStatusId1") int bookingStatusId1,
                        @Param("bookingStatusId2") int bookingStatusId2,
                        Pageable page);

        @Query("SELECT ts.timeSlotId, ts.timeBegin, ts.timeEnd, s.booked "
                        + "FROM Schedule s "
                        + "JOIN s.timeSlotId ts "
                        + "JOIN s.profileDoctorId pd "
                        + "WHERE pd.profileDoctorId = :profileDoctorId "
                        + "AND s.date = :date")
        List<Object[]> getTimeSlotsForDoctorOnDate(@Param("profileDoctorId") int profileDoctorId,
                        @Param("date") Date date);

        @Query("SELECT DISTINCT s.date "
                        + "FROM Schedule s "
                        + "JOIN s.timeSlotId ts "
                        + "JOIN s.profileDoctorId pd "
                        + "WHERE pd.profileDoctorId = :profileDoctorId "
                        + "AND s.date >= CURRENT_DATE "
                        + "ORDER BY s.date ASC ")
        List<?> getDatesForProfileDoctor(@Param("profileDoctorId") int profileDoctorId);

        // Cái này truy vấn thêm cái ID của Booking có trong Prescription
        // @Query("SELECT b.bookingId, pd.name, s.date, ts.timeBegin, ts.timeEnd,
        // bs.statusValue, pp.name, u.firstname, u.lastname, "
        // + "CASE WHEN EXISTS (SELECT 1 FROM Prescriptions p WHERE p.bookingId = b)
        // THEN true ELSE false END "
        // + "FROM Booking b "
        // + "JOIN b.scheduleId s "
        // + "JOIN s.profileDoctorId pd "
        // + "JOIN b.statusId bs "
        // + "JOIN b.profilePatientId pp "
        // + "JOIN pp.userId u "
        // + "JOIN s.timeSlotId ts "
        // + "WHERE pd.profileDoctorId = :profileDoctorId")
        @Query("SELECT b.bookingId, pd.name, s.date, ts.timeBegin, ts.timeEnd, bs.statusValue, pp.name, u.firstname, u.lastname "
                        + "FROM Booking b "
                        + "JOIN b.scheduleId s "
                        + "JOIN s.profileDoctorId pd "
                        + "JOIN b.statusId bs "
                        + "JOIN b.profilePatientId pp "
                        + "JOIN pp.userId u "
                        + "JOIN s.timeSlotId ts "
                        + "WHERE pd.profileDoctorId = :profileDoctorId")
        List<Object[]> getBookingForDoctorView(@Param("profileDoctorId") int profileDoctorId);

        @Query("SELECT b.bookingId, pd.name, s.date, ts.timeBegin, ts.timeEnd, bs.statusValue, pp.name, u.firstname, u.lastname, b.linkVideoCall, b.profilePatientId, b.scheduleId.profileDoctorId "
                        // @Query("SELECT b "
                        + "FROM Booking b "
                        + "JOIN b.scheduleId s "
                        + "JOIN s.profileDoctorId pd "
                        + "JOIN b.statusId bs "
                        + "JOIN b.profilePatientId pp "
                        + "JOIN pp.userId u "
                        + "JOIN s.timeSlotId ts "
                        + "WHERE pd.profileDoctorId = :profileDoctorId "
                        + "AND bs.statusId = :bookingStatusId")
        Page<?> getBookingForDoctorViewPage(@Param("profileDoctorId") int profileDoctorId,
                        @Param("bookingStatusId") int bookingStatusId, Pageable page);

        @Query("SELECT pd.name, pd.workAddress, pd.specialtyId, pd.bookingPrice, s.date, pp.name, pp.birthday, pp.phonenumber, pp.address, pp.gender, pd.userId, b.bookingCancel, b.statusId, b.bookingId "
                        + "FROM Booking b "
                        + "JOIN b.scheduleId s "
                        + "JOIN b.profilePatientId pp "
                        + "JOIN s.profileDoctorId pd "
                        + "WHERE b.bookingId = :bookingId")
        List<Object[]> getBookingDetailsByBookingId(@Param("bookingId") int bookingId);

}
