package com.dh.DentistClinicHibernate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer dentist_id;
    private String name;
    private String lastname;
    private Integer enrollment;

}
