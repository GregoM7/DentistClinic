package com.dh.DentistClinicHibernate.repository;

import com.dh.DentistClinicHibernate.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
