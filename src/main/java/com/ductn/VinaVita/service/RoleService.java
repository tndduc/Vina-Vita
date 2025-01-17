/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import com.ductn.VinaVita.models.Role;

import java.util.List;

/**
 *
 * @author Administrator
 */

public interface RoleService {
    Role findRoleByRoleNameAndActiveTrue(String roleName);
    List<Role> saveList(List<Role> roleList);
    Role findRoleByRoleIdAndActiveTrue(int roleId);
    long count();
    List<Role> findRoleByActiveTrue();
}
