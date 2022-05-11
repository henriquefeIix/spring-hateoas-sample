package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assembler.PhoneAssembler;
import com.example.demo.dto.PhoneDTO;
import com.example.demo.model.Phone;
import com.example.demo.service.PhoneService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/phones")
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;
    private final PagedResourcesAssembler<Phone> pagedAssembler;
    private final PhoneAssembler phoneAssembler;

    @GetMapping
    public PagedModel<PhoneDTO> findAll(Pageable pageable) {
        Page<Phone> phones = this.phoneService.findAll(pageable);
        return this.pagedAssembler.toModel(phones, this.phoneAssembler);
    }

    @GetMapping("/{id}")
    public PhoneDTO findById(@PathVariable Integer id) {
        return this.phoneAssembler.toModel(this.phoneService.findById(id));
    }

}
