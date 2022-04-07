package com.dh.DentistClinicHibernate.entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer appointment_id;

    private LocalDate date;

}
