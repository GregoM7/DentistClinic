package com.dh.DentistClinicHibernate.repository;

import com.dh.DentistClinicHibernate.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
