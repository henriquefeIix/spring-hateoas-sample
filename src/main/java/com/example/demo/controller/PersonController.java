package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assembler.PersonAssembler;
import com.example.demo.dto.PersonDTO;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final PagedResourcesAssembler<Person> pagedAssembler;
    private final PersonAssembler personAssembler;

    @GetMapping
    public CollectionModel<PersonDTO> findAll(Pageable pageable) {
        Page<Person> people = this.personService.findAll(pageable);
        return this.pagedAssembler.toModel(people, personAssembler);
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Integer id) {
        return this.personAssembler.toModel(this.personService.findById(id));
    }

}
