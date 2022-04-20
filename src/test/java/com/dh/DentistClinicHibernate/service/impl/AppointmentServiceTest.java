package com.dh.DentistClinicHibernate.service.impl;

import com.dh.DentistClinicHibernate.dto.AddressDTO;
import com.dh.DentistClinicHibernate.dto.AppointmentDTO;
import com.dh.DentistClinicHibernate.dto.DentistDTO;
import com.dh.DentistClinicHibernate.dto.PatientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AppointmentServiceTest {

    @Autowired
    AppointmentService appointmentService;
    @Autowired
    DentistService dentistService;
    @Autowired
    PatientService patientService;

    @Test
    void findById() {

    }

    @Test
    void create() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet("Hola");
        addressDTO.setNumber("123");
        addressDTO.setCity("juan carlos");
        addressDTO.setState("regina");
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Zoe");
        patientDTO.setLastname("Tira");
        patientDTO.setIdentitycard(23231);
        patientDTO.setDateofadmission(LocalDate.now());
        patientDTO.setAddress(addressDTO);
        PatientDTO newPatientDTO = patientService.create(patientDTO);
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Grego");
        dentistDTO.setLastname("Martinez");
        dentistDTO.setEnrollment(2323);
        DentistDTO newDentistDTO = dentistService.create(dentistDTO);
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setDate(LocalDate.parse("2000-10-11"));
        appointmentDTO.setPatient(newPatientDTO);
        appointmentDTO.setDentist(newDentistDTO);
        AppointmentDTO newappointmentDTO = appointmentService.create(appointmentDTO);
        assertTrue(appointmentService.findAll().size() > 0);

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