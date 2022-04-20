package com.dh.DentistClinicHibernate.controller;

import com.dh.DentistClinicHibernate.dto.DentistDTO;

import com.dh.DentistClinicHibernate.service.impl.DentistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/dentist")
public class DentistController {
    @Autowired
    private DentistService dentistservice;

    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> findById(@PathVariable("id")Integer id){
        DentistDTO dentistDTO = dentistservice.findById(id);
        return new ResponseEntity<>(dentistDTO, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<DentistDTO> create(@RequestBody DentistDTO dentistdto){
        DentistDTO newdentistDTO = dentistservice.create(dentistdto);
        return new ResponseEntity<>(newdentistDTO, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<DentistDTO> update(@RequestBody DentistDTO dentistDTO){
        DentistDTO newdentistdto = dentistservice.update(dentistDTO);
        return new ResponseEntity<>(newdentistdto, HttpStatus.OK);
    };
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        dentistservice.deleteById(id);
        return new ResponseEntity<>("Dentist Eliminated", HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<DentistDTO>> findAll(){
        List<DentistDTO> dentistlist = dentistservice.findAll();
        return new ResponseEntity<>(dentistlist, HttpStatus.OK);
    }
}
