package com.dh.DentistClinicHibernate.dto;

import com.dh.DentistClinicHibernate.entity.Address;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PatientDTO {
    private Integer id;
    private String name;
    private String lastname;
    private Integer identitycard;
    private LocalDate dateofadmission;
    private String email;
    private AddressDTO address;
}
