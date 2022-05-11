package com.example.demo.dto;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "people", itemRelation = "person")
public class PersonDTO extends RepresentationModel<PersonDTO> {

    private Integer id;

    private String name;

    private List<PhoneDTO> phones;

}
