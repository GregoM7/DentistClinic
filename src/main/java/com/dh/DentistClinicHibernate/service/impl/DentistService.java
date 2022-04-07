package com.dh.DentistClinicHibernate.service.impl;

import com.dh.DentistClinicHibernate.dto.DentistDTO;
import com.dh.DentistClinicHibernate.entity.Dentist;
import com.dh.DentistClinicHibernate.repository.DentistRepository;
import com.dh.DentistClinicHibernate.service.IDentistService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService implements IDentistService{
    @Autowired
    private DentistRepository dentistRepository;
    @Autowired
    private ModelMapper mapper;

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
        Dentist dentist =dentistRepository.getById(id);
        dentistRepository.delete(dentist);
    }

    @Override
    public DentistDTO update(DentistDTO dentistDTO) {
        Dentist dentist = mapEntity(dentistDTO);
        Dentist newdentistsave = dentistRepository.save(dentist);
        return mapDTO(newdentistsave);
    }

    @Override
    public List<DentistDTO> findAll() {
        return null;
    }


    //------ MAPPER----
    private DentistDTO mapDTO(Dentist dentist){
        DentistDTO dentistDTO = mapper.map(dentist, DentistDTO.class);
        return dentistDTO;
    }

    private Dentist mapEntity(DentistDTO dentistDTO){
        Dentist dentist = mapper.map(dentistDTO, Dentist.class);
        return dentist;
    }
}

