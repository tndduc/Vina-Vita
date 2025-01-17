/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.repository;

import com.ductn.VinaVita.models.User;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsernameAndActiveTrue(String username);

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByUserIdAndActiveTrue(int userId);

    @Query("SELECT u FROM User u WHERE u.active = true")
    List<User> findUserByActiveTrue();

    @Query("SELECT u FROM User u WHERE u.active = true")
    Page<User> findUserByActiveTruePage(Pageable page);
//    Page<User> findUserPageSpec(Specification specification, Pageable page);

//    List<User> findAll(Specification<User> createSpecification, Pageable page);
    
    Page<User> findAll(Specification<User> createSpecification, Pageable page);
}
