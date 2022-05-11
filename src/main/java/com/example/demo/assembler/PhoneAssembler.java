package com.example.demo.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.example.demo.controller.PhoneController;
import com.example.demo.converter.MapperConverter;
import com.example.demo.dto.PhoneDTO;
import com.example.demo.model.Phone;

@Component
public class PhoneAssembler extends RepresentationModelAssemblerSupport<Phone, PhoneDTO> {

    public PhoneAssembler() {
        super(PhoneController.class, PhoneDTO.class);
    }

    @Override
    public PhoneDTO toModel(Phone entity) {
        PhoneDTO phone = super.createModelWithId(entity.getId(), entity);
        MapperConverter.parse(entity, phone);
        return phone;
    }

    @Override
    public CollectionModel<PhoneDTO> toCollectionModel(Iterable<? extends Phone> entities) {
        return super.toCollectionModel(entities);
    }

}
