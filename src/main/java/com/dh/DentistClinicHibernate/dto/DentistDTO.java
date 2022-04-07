package com.dh.DentistClinicHibernate.dto;

import lombok.Data;

@Data
public class DentistDTO {
    private Integer dentist_id;
    private String name;
    private String lastname;
    private Integer enrollment;
}
