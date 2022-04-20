package com.dh.DentistClinicHibernate.service.impl;

import com.dh.DentistClinicHibernate.dto.DentistDTO;
import com.dh.DentistClinicHibernate.dto.PatientDTO;
import com.dh.DentistClinicHibernate.entity.Dentist;
import com.dh.DentistClinicHibernate.entity.Patient;
import com.dh.DentistClinicHibernate.repository.DentistRepository;
import com.dh.DentistClinicHibernate.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistService implements IDentistService{
    @Autowired
    private DentistRepository dentistRepository;
    @Autowired
    private ObjectMapper mapper;

    public DentistDTO findById(@NotNull Integer id){
        Dentist dentist = dentistRepository.getById(id);
        return mapDTO(dentist);
    }

    @Override
    public DentistDTO create(DentistDTO dentistDTO) {
        Dentist dentist = mapEntity(dentistDTO);
        Dentist newdentistsave = dentistRepository.save(dentist);
        return mapDTO(newdentistsave);
    }

    @Override
    public void deleteById(Integer id) {
        Dentist dentist = dentistRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el dentista"));
        dentistRepository.delete(dentist);
    }

    @Override
    public DentistDTO update(DentistDTO dentistDTO) {
        Dentist dentist = dentistRepository.findById(dentistDTO.getId())
                .orElseThrow(()-> new RuntimeException("No se encontro el dentista"));
        dentist.setName(dentistDTO.getName());
        dentist.setLastname(dentistDTO.getLastname());
        dentist.setEnrollment(dentistDTO.getEnrollment());
        Dentist dentistsave = dentistRepository.save(dentist);
        return mapDTO(dentistsave);
    }

    @Override
    public List<DentistDTO> findAll() {
        List<Dentist> listDentist = dentistRepository.findAll();
        List<DentistDTO> listDentistDTO = listDentist.stream().map(item -> mapDTO(item)).collect(Collectors.toList());
        return listDentistDTO;
    }


    //------ MAPPER----
    private DentistDTO mapDTO(Dentist dentist){
        DentistDTO dentistDTO = mapper.convertValue(dentist, DentistDTO.class);
        return dentistDTO;
    }

    public Dentist mapEntity(DentistDTO dentistDTO){
        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        return dentist;
    }
}

