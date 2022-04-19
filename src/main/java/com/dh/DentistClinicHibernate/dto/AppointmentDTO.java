package com.dh.DentistClinicHibernate.dto;


import com.dh.DentistClinicHibernate.entity.Dentist;
import com.dh.DentistClinicHibernate.entity.Patient;
import lombok.Data;

import java.time.LocalDate;
@Data
public class AppointmentDTO {
    private Integer id;
    private LocalDate date;
    private DentistDTO dentist;
    private PatientDTO patient;
}
