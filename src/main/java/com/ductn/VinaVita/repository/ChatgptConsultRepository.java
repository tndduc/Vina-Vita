/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.repository;

import com.ductn.VinaVita.models.ChatgptConsult;
import com.ductn.VinaVita.models.ChatgptQuestion;
import com.ductn.VinaVita.models.User;

import java.util.Optional;
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
public interface ChatgptConsultRepository extends JpaRepository<ChatgptConsult, Integer> {
        Page<ChatgptConsult> findByUserIdOrderByCreatedDateDesc(User userId, Pageable page);

        Optional<ChatgptConsult> findByChatgptConsultId(Integer chatgptConsultId);

        Optional<ChatgptConsult> findByChatgptQuestionId(ChatgptQuestion chatgptQuestionId);
}
