/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.dto.AddCommentDTO;
import com.ductn.VinaVita.dto.UpdateCommentDTO;

import java.util.List;
import java.util.Map;

import com.ductn.VinaVita.models.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */
public interface CommentService {

    int softDeleteComment(int commentId);

    Comment findCommentByCommentIdAndActiveTrue(int commentId);

    int addComment(AddCommentDTO addCommentDTO, MultipartFile avatar);

    int updateComment(UpdateCommentDTO updateCommentDTO, MultipartFile avatar);

    List<Object[]> checkComment(@Param("userId") int userId, @Param("profileDoctorId") int profileDoctorId);

    Page<Comment> findAllCommentPageSpec(Map<String, String> params);

    Page<Comment> findCommentByProfileDoctorIdPage(int profileDoctorId, Map<String, String> params);
}
