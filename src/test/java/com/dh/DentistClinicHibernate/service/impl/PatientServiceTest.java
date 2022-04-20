package com.dh.DentistClinicHibernate.service.impl;

import com.dh.DentistClinicHibernate.dto.AddressDTO;
import com.dh.DentistClinicHibernate.dto.PatientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientServiceTest {

    @Autowired
    private PatientService patientService;
    @Test
    void findById() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Zoe");
        patientDTO.setLastname("Tira");
        PatientDTO newPatientDTO = patientService.create(patientDTO);
        assertNotNull(patientService.findById(newPatientDTO.getId()));
    }

    @Test
    void create() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Zoe");
        patientDTO.setLastname("Tira");
        PatientDTO newPatientDTO = patientService.create(patientDTO);
        assertNotNull(patientService.findById(newPatientDTO.getId()));
    }

    @Test
    void deleteById() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Zoe");
        patientDTO.setLastname("Tira");
        PatientDTO newPatientDTO = patientService.create(patientDTO);
        assertNotNull(patientService.findById(newPatientDTO.getId()));
        patientService.deleteById(newPatientDTO.getId());
        assertThrows(RuntimeException.class,()-> patientService.findById(newPatientDTO.getId()));
    }

    @Test
    void update() {
        PatientDTO patient = new PatientDTO();
        patient.setName("Zaira");
        patient.setLastname("Tira");
        patient.setIdentitycard(123);
        patient.setDateofadmission(LocalDate.now());
        patient.setAddress(new AddressDTO());
        PatientDTO np = patientService.create(patient);
        np.setName("Zoe");
        patientService.update(np);
        PatientDTO p1 = patientService.findById(np.getId());
        assertEquals(p1.getName(),"Zoe");
    }

    @Test
    void findAll() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Zoe");
        patientDTO.setLastname("Tira");
        PatientDTO newPatientDTO = patientService.create(patientDTO);
        PatientDTO patientDTO2 = new PatientDTO();
        patientDTO2.setName("Grego");
        patientDTO2.setLastname("Martinez");
        PatientDTO newPatientDTO2 = patientService.create(patientDTO2);
        assertNotNull(patientService.findAll());
        assertTrue(patientService.findAll().size() > 1);
    }
}