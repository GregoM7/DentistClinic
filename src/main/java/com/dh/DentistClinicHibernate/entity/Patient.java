package com.dh.DentistClinicHibernate.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer pacient_id;
    private String name;
    private String lastname;
    private Integer identitycard;
    private LocalDate dateofadmission;


}