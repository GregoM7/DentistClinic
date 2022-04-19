package com.dh.DentistClinicHibernate.controller;

import com.dh.DentistClinicHibernate.dto.AppointmentDTO;
import com.dh.DentistClinicHibernate.dto.DentistDTO;
import com.dh.DentistClinicHibernate.exceptions.ResourceNotFoundException;
import com.dh.DentistClinicHibernate.service.impl.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable("id")Integer id){
        AppointmentDTO appointmentDTO = appointmentService.findById(id);
        return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO appointmentDTO)  {
        AppointmentDTO newappointmentDTO = appointmentService.create(appointmentDTO);
        return new ResponseEntity<>(newappointmentDTO, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<AppointmentDTO> update(@RequestBody AppointmentDTO appointmentDTO){
        AppointmentDTO newappointmentDTO = appointmentService.update(appointmentDTO);
        return new ResponseEntity<>(newappointmentDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
         appointmentService.deleteById(id);
         return new ResponseEntity<>("Se elimino el turno", HttpStatus.OK);
    }
    
}
