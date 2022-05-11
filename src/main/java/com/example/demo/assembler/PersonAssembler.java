package com.example.demo.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.example.demo.controller.PersonController;
import com.example.demo.converter.MapperConverter;
import com.example.demo.dto.PersonDTO;
import com.example.demo.model.Person;

@Component
public class PersonAssembler extends RepresentationModelAssemblerSupport<Person, PersonDTO> {

    public PersonAssembler() {
        super(PersonController.class, PersonDTO.class);
    }

    @Override
    public PersonDTO toModel(Person entity) {
        PersonDTO person = super.createModelWithId(entity.getId(), entity);
        MapperConverter.parse(entity, person);
        return person;
    }

    @Override
    public CollectionModel<PersonDTO> toCollectionModel(Iterable<? extends Person> entities) {
        return super.toCollectionModel(entities);
    }

}
