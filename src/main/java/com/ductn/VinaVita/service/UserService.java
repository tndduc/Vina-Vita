/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.dto.*;

import java.util.List;
import java.util.Map;

import com.ductn.VinaVita.models.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */
public interface UserService extends UserDetailsService {

    List<User> findAllUser();

    User findUserByUsernameAndActiveTrue(String username);

    User findUserByUsername(String username);

    User findUserByUserIdAndActiveTrue(int userId);

    User addUser(Map<String, String> params, MultipartFile avatar);

    int addUser(AddUserForAdminDTO addUserForAdminDTO, MultipartFile avatar);

    int registerUser(RegisterDTO registerDTO);

    int updateUser(UpdateUserForUserDTO updateUserForUserDTO, MultipartFile avatar);

    int updateUser(UpdateUserForAdminDTO updateUserForAdminDTO, MultipartFile avatar);

    int changePassword(ChangePasswordDTO changePasswordDTO);

    int forgotPassword(ForgotPasswordDTO forgotPasswordDTO);

    Page<User> findAllUserPage(int pageNumber);

    Page<User> findAllUserPageSpec(Map<String, String> params);

    int softDeleteUser(int userId);

//    Page<User> findAllUserPageSpec_test(Map<String, String> params);
}
