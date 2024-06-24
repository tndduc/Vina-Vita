/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.models.ChatgptConsult;
import com.ductn.VinaVita.models.ChatgptQuestion;
import com.ductn.VinaVita.models.User;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Administrator
 */
public interface ChatgptConsultService {

    Page<ChatgptConsult> findByUserIdOrderByCreatedDateDesc(User userId, Pageable page);

    Optional<ChatgptConsult> findByChatgptConsultId(Integer chatgptConsultId);

    Optional<ChatgptConsult> findByChatgptQuestionId(ChatgptQuestion chatgptQuestionId);

    ChatgptConsult addChatgptConsult(ChatgptConsult chatgptConsult);
}
