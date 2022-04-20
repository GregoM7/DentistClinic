package com.dh.DentistClinicHibernate.service.impl;

import com.dh.DentistClinicHibernate.dto.DentistDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DentistServiceTest {

    @Autowired
    DentistService dentistService;

    @Test
    void findById() {
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Grego");
        dentistDTO.setLastname("Martinez");
        dentistDTO.setEnrollment(21312);
        DentistDTO newdentistDTO = dentistService.create(dentistDTO);
        assertNotNull(dentistService.findById(newdentistDTO.getId()));
    }

    @Test
    void create() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
    }
}