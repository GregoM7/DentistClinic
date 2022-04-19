package com.dh.DentistClinicHibernate.service.impl;

import com.dh.DentistClinicHibernate.dto.AddressDTO;
import com.dh.DentistClinicHibernate.dto.PatientDTO;
import com.dh.DentistClinicHibernate.entity.Address;
import com.dh.DentistClinicHibernate.entity.Patient;
import com.dh.DentistClinicHibernate.service.IAddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressService implements IAddressService {
    @Autowired
    private ModelMapper mapper;
    @Override
    public AddressDTO findById(Integer id) {
        return null;
    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        return null;
    }

    @Override
    public List<AddressDTO> findAll() {
        return null;
    }

    //-------MAPPER-------//
    private AddressDTO mapDTO(Address address){
        AddressDTO addressDTO = mapper.map(address, AddressDTO.class);
        return addressDTO;
    }

    public Address mapEntity(AddressDTO addressDTO){
        Address address = mapper.map(addressDTO, Address.class);
        return address;
    }
}
