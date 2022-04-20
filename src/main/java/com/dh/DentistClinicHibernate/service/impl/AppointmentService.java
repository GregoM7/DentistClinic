package com.dh.DentistClinicHibernate.service.impl;

import com.dh.DentistClinicHibernate.dto.AppointmentDTO;
import com.dh.DentistClinicHibernate.dto.DentistDTO;
import com.dh.DentistClinicHibernate.dto.PatientDTO;
import com.dh.DentistClinicHibernate.entity.Appointment;
import com.dh.DentistClinicHibernate.entity.Dentist;
import com.dh.DentistClinicHibernate.entity.Patient;
import com.dh.DentistClinicHibernate.repository.AppointmentRepository;
import com.dh.DentistClinicHibernate.service.IAppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class AppointmentService implements IAppointmentService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DentistService dentistService;
    @Autowired
    private PatientService patientService;

    @Override
    public AppointmentDTO findById(Integer id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el turno"));
        return mapDTO(appointment);
    }

    @Override
    public AppointmentDTO create(AppointmentDTO appointmentDTO) {
            //Nos aseguramos que tanto el odontologo como el paciente existan en la base de datos
            PatientDTO patientDTO = patientService.findById(appointmentDTO.getPatient().getId());
            DentistDTO dentistDTO = dentistService.findById(appointmentDTO.getDentist().getId());

            //Creamos el turno
            Appointment appointment = mapEntity(appointmentDTO);
            //ver fecha
            appointment.setDate(appointmentDTO.getDate());
            appointment.setPatient(patientService.mapEntity(patientDTO));
            appointment.setDentist(dentistService.mapEntity(dentistDTO));
            //Guardamos el turno en la base de datos
            appointment = appointmentRepository.save(appointment);
            //Retornamos el turno
            return mapDTO(appointment);
        }

    @Override
    public void deleteById(Integer id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el paciente"));
        appointmentRepository.delete(appointment);
    }

    @Override
    public AppointmentDTO update(AppointmentDTO appointmentDTO) {
        PatientDTO patientDTO = patientService.findById(appointmentDTO.getPatient().getId());
        DentistDTO dentistDTO = dentistService.findById(appointmentDTO.getDentist().getId());
        Appointment appointment = mapEntity(appointmentDTO);
        appointment.setPatient(patientService.mapEntity(patientDTO));
        appointment.setDentist(dentistService.mapEntity(dentistDTO));
        appointment = appointmentRepository.save(mapEntity(appointmentDTO));
        return mapDTO(appointment);
    }

    @Override
    public List<AppointmentDTO> findAll() {
        List<Appointment> listappointments = appointmentRepository.findAll();
        List<AppointmentDTO> listDto = listappointments.stream().map(item -> mapDTO(item)).collect(Collectors.toList());
        return listDto;
    }

    //-MAPPER-//
    private AppointmentDTO mapDTO(Appointment appointment){
       AppointmentDTO appointmentDTO = mapper.map(appointment, AppointmentDTO.class);
        return appointmentDTO;
    }

    private Appointment mapEntity(AppointmentDTO appointmentDTO){
        Appointment appointment = mapper.map(appointmentDTO, Appointment.class);
        return appointment;
    }
}
