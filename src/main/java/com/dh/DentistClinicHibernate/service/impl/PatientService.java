package com.dh.DentistClinicHibernate.service.impl;

import com.dh.DentistClinicHibernate.dto.PatientDTO;
import com.dh.DentistClinicHibernate.entity.Patient;
import com.dh.DentistClinicHibernate.repository.PatientRepository;
import com.dh.DentistClinicHibernate.service.IPatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AddressService addressService;
    
    @Override
    public PatientDTO findById(Integer id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el paciente"));
        return mapDTO(patient);
    }

    @Override
    public PatientDTO create(PatientDTO patientDTO) {
        patientDTO.setDateofadmission(LocalDate.now());
        Patient patient = patientRepository.save(mapEntity(patientDTO));
        return mapDTO(patient);
    }

    @Override
    public void deleteById(Integer id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el paciente"));
        patientRepository.delete(patient);
        // patientRepository.deleteById(id);
    }

    @Override
   public PatientDTO update(PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(patientDTO.getId())
                .orElseThrow(()-> new RuntimeException("No se encontro el paciente"));
        patient.setName(patientDTO.getName());
        patient.setLastname(patientDTO.getLastname());
        patient.setIdentitycard(patientDTO.getIdentitycard());
        patient.setDateofadmission(patientDTO.getDateofadmission());
        patient.setAddress(addressService.mapEntity(patientDTO.getAddress()));
        Patient patientsave = patientRepository.save(patient);
        return mapDTO(patientsave);
    }
    //public void guardarPaciente(PacienteDTO pacienteDTO) {
        //convertimos el dto en json
      //  Paciente paciente = mapEntity(pacienteDTO,)
        //vemos que metodo tiene en repository paa guardar
       // pacienteRepository.save(paciente);

   // }
   // public void crear(PacienteDTO pacienteDTO) {
     //   guardarPaciente(pacienteDTO);
        //logger.info("Se creo al  paciente" + pacienteDTO.getNombre() + " "+ pacienteDTO.getApellido()   );


   // }

    @Override
    public List<PatientDTO> findAll() {
        List<Patient> listPatient = patientRepository.findAll();
        List<PatientDTO> listDto = listPatient.stream().map(item -> mapDTO(item)).collect(Collectors.toList());
        return listDto;
    }


    /*public Patient findByEmail(String email) {
         return patientRepository.findByEmail(email);
    }*/


    //-------MAPPER-------//
    private PatientDTO mapDTO(Patient patient){
        PatientDTO patientDTO = mapper.map(patient, PatientDTO.class);
        return patientDTO;
    }

    public Patient mapEntity(PatientDTO patientDTO){
        Patient patient = mapper.map(patientDTO, Patient.class);
        return patient;
    }
}
