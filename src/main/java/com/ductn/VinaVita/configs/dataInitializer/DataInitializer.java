package com.ductn.VinaVita.configs.dataInitializer;

import com.ductn.VinaVita.models.Role;
import com.ductn.VinaVita.repository.RoleRepository;
import com.ductn.VinaVita.service.ProvincesService;
import com.ductn.VinaVita.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        if (roleService.count() == 0) {
            log.info("Creating roles...");
            createRoles();
            log.info("Roles created.");
        }
    }

    private void createRoles() {
        List<Role> roleList = new ArrayList<>();
        roleList.add(Role.builder().roleName("ROLE_ADMIN").active(true).createdDate(new Date()).build());
        roleList.add(Role.builder().roleName("ROLE_DOCTOR").active(true).createdDate(new Date()).build());
        roleList.add(Role.builder().roleName("ROLE_USER").active(true).createdDate(new Date()).build());
        roleList.add(Role.builder().roleName("ROLE_NURSE").active(true).createdDate(new Date()).build());
        roleService.saveList(roleList);
    }
}
