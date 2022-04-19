package com.dh.DentistClinicHibernate.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private Integer id;
    private String street;
    private String number;
    private String city;
    private String state;
}
