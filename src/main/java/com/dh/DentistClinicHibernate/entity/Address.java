package com.dh.DentistClinicHibernate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "addreses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String number;
    private String city;
    private String state;

}
