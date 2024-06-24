/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.service;

import java.util.Optional;

import com.ductn.VinaVita.models.TestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author Administrator
 */
public interface TestServiceService {
        Optional<TestService> findByTestServiceId(Integer testServiceId);

        Page<?> findAllTestServicePageSpec(Specification<?> createSpecification, Pageable page);
}
