package com.dh.DentistClinicHibernate.controller;

import com.dh.DentistClinicHibernate.dto.PatientDTO;
import com.dh.DentistClinicHibernate.service.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable("id")Integer id){
        PatientDTO patientDTO = patientService.findById(id);
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<PatientDTO> create(@RequestBody PatientDTO patientDTO){
        PatientDTO newPatientDTO = patientService.create(patientDTO);
        return new ResponseEntity<>(newPatientDTO, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<PatientDTO> update(@RequestBody PatientDTO patientDTO){
       PatientDTO newpatientdto = patientService.update(patientDTO);
       return new ResponseEntity<>(newpatientdto, HttpStatus.OK);
    };
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        patientService.deleteById(id);
        return new ResponseEntity<>("Patient Eliminated", HttpStatus.OK);
    }


}
