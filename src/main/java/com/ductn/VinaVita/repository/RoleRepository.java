/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.repository;

import java.util.List;
import java.util.Optional;

import com.ductn.VinaVita.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findRoleByRoleNameAndActiveTrue(String roleName);
    Optional<Role> findRoleByRoleIdAndActiveTrue(int roleId);
    List<Role> findRoleByActiveTrue();
}
