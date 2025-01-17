/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service.Impl;

import com.ductn.VinaVita.components.datetime.DateFormatComponent;
import com.ductn.VinaVita.dto.AddProfilePatientDTO;
import com.ductn.VinaVita.dto.UpdateProfilePatientDTO;
import com.ductn.VinaVita.models.Booking;
import com.ductn.VinaVita.models.ProfilePatient;
import com.ductn.VinaVita.models.User;
import com.ductn.VinaVita.repository.BookingRepository;
import com.ductn.VinaVita.repository.ProfilePatientRepository;
import com.ductn.VinaVita.repository.UserRepository;
import com.ductn.VinaVita.service.BookingService;
import com.ductn.VinaVita.service.ProfilePatientService;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
public class ProfilePatientServiceImpl implements ProfilePatientService {

    @Autowired
    private ProfilePatientRepository profilePatientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DateFormatComponent dateFormatComponent;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingService bookingService;

    @Override
    public int addProfilePatient(AddProfilePatientDTO addProfilePatientDTO) {
        try {
            ProfilePatient profilePatient = new ProfilePatient();

            profilePatient.setName(addProfilePatientDTO.getName());
            profilePatient.setPhonenumber(addProfilePatientDTO.getPhonenumber());
            profilePatient.setGender(addProfilePatientDTO.getGender());
            profilePatient
                    .setBirthday(this.dateFormatComponent.myDateFormat().parse(addProfilePatientDTO.getBirthday()));
            profilePatient.setProvinceName(addProfilePatientDTO.getProvinceName());
            profilePatient.setDistrictName(addProfilePatientDTO.getDistrictName());
            profilePatient.setWardName(addProfilePatientDTO.getWardName());
            profilePatient.setPersonalAddress(addProfilePatientDTO.getPersonalAddress());
            profilePatient.setAddress(
                    addProfilePatientDTO.getPersonalAddress()
                            + " " + addProfilePatientDTO.getWardName()
                            + " " + addProfilePatientDTO.getDistrictName()
                            + " " + addProfilePatientDTO.getProvinceName());

            profilePatient.setEmail(addProfilePatientDTO.getEmail());
            profilePatient.setRelationship(addProfilePatientDTO.getRelationship());

            // Optional<User> userOptional =
            // this.userRepository.findById(Integer.parseInt(addProfilePatientDTO.getUserId()));
            Optional<User> userOptional = this.userRepository
                    .findUserByUserIdAndActiveTrue(Integer.parseInt(addProfilePatientDTO.getUserId()));
            if (userOptional.isPresent()) {
                profilePatient.setUserId(userOptional.get());
            }

            profilePatient.setIsLock(Boolean.FALSE);
            profilePatient.setActive(Boolean.TRUE);
            profilePatient.setCreatedDate(new Date());

            this.profilePatientRepository.save(profilePatient);
            return 1;
        } catch (DataAccessException ex) {
            Logger.getLogger(ProfilePatientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (NoSuchElementException ex) {
            Logger.getLogger(ProfilePatientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (ParseException ex) {
            Logger.getLogger(ProfilePatientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    @Override
    public int updateProfilePatient(UpdateProfilePatientDTO updateProfilePatientDTO) {
        try {
            Optional<ProfilePatient> profilePatientOptional = this.profilePatientRepository
                    .findProfilePatientByProfilePatientIdAndActiveTrue(
                            Integer.parseInt(updateProfilePatientDTO.getProfilePatientId()));

            if (profilePatientOptional.isPresent()) {

                ProfilePatient profilePatient = profilePatientOptional.get();
                profilePatient.setName(updateProfilePatientDTO.getName());
                profilePatient.setPhonenumber(updateProfilePatientDTO.getPhonenumber());
                profilePatient.setGender(updateProfilePatientDTO.getGender());
                profilePatient.setBirthday(
                        this.dateFormatComponent.myDateFormat().parse(updateProfilePatientDTO.getBirthday()));
                profilePatient.setProvinceName(updateProfilePatientDTO.getProvinceName());
                profilePatient.setDistrictName(updateProfilePatientDTO.getDistrictName());
                profilePatient.setWardName(updateProfilePatientDTO.getWardName());
                profilePatient.setPersonalAddress(updateProfilePatientDTO.getPersonalAddress());
                profilePatient.setAddress(
                        updateProfilePatientDTO.getPersonalAddress()
                                + " " + updateProfilePatientDTO.getWardName()
                                + " " + updateProfilePatientDTO.getDistrictName()
                                + " " + updateProfilePatientDTO.getProvinceName());

                profilePatient.setEmail(updateProfilePatientDTO.getEmail());
                profilePatient.setRelationship(updateProfilePatientDTO.getRelationship());

                profilePatient.setActive(Boolean.TRUE);
                profilePatient.setUpdatedDate(new Date());

                this.profilePatientRepository.save(profilePatient);
                return 1;
            } else {
                return 0;
            }

        } catch (DataAccessException ex) {
            Logger.getLogger(ProfilePatientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return 0;
        } catch (NoSuchElementException ex) {
            Logger.getLogger(ProfilePatientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (ParseException ex) {
            Logger.getLogger(ProfilePatientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public ProfilePatient findProfilePatientByProfilePatientIdAndActiveTrue(int profilePatientId) {
        try {
            Optional<ProfilePatient> profilePatientOptional = this.profilePatientRepository
                    .findProfilePatientByProfilePatientIdAndActiveTrue(profilePatientId);
            if (profilePatientOptional.isPresent()) {
                return profilePatientOptional.get();
            } else {
                return null;
            }
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    @Override
    public List<ProfilePatient> findProfilePatientByUserIdAndActiveTrue(int userId) {
        try {
            return this.profilePatientRepository.findProfilePatientByUserIdAndActiveTrue(
                    this.userRepository.findUserByUserIdAndActiveTrue(userId).get());
        } catch (NoSuchElementException ex) {
            return null;
        }

    }

    @Override
    @Transactional
    public int softDeleteProfilePatient(int profilePatientId) {
        Optional<ProfilePatient> profilePatientOptional = this.profilePatientRepository
                .findProfilePatientByProfilePatientIdAndActiveTrue(profilePatientId);
        if (profilePatientOptional.isPresent()) {
            ProfilePatient profilePatient = profilePatientOptional.get();
            if (profilePatient.getActive().equals(Boolean.TRUE)) {
                profilePatient.setActive(Boolean.FALSE);

                List<Booking> listBooking = this.bookingRepository
                        .findBookingByProfilePatientIdAndActiveTrue(profilePatient);

                for (Booking booking : listBooking) {
                    this.bookingService.softDeleteBooking(booking.getBookingId());
                }
                return 1;
            } else {
                System.out.println("ProfilePatient: " + profilePatient.getActive());
                return 2;
            }
        } else {
            return 3; // Không tìm được để xóa
        }
    }

    @Override
    public Optional<ProfilePatient> findProfilePatientByProfilePatientIdAndActiveTrueOptional(int profilePatientId) {
        return this.profilePatientRepository.findProfilePatientByProfilePatientIdAndActiveTrue(profilePatientId);
    }

    @Override
    public List<?> findProfilePatientByUserIdAndIsLockAndActiveTrue(User userId, Boolean lock) {
        return this.profilePatientRepository.findProfilePatientByUserIdAndIsLockAndActiveTrue(userId, lock);
    }

    @Override
    public Page<?> findAllProfilePatientPageSpec(Specification<?> createSpecification, Pageable page) {
        return this.profilePatientRepository.findAll(createSpecification, page);
    }
}
