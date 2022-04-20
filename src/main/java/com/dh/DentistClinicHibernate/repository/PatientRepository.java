package com.dh.DentistClinicHibernate.repository;

import com.dh.DentistClinicHibernate.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

   // @Query("SELECT * FROM patients WHERE email = ?1")
    //public Patient findByEmail (String email);

}
