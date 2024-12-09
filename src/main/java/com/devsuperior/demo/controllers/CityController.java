package com.devsuperior.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.services.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {

  @Autowired
  private CityService service;

  @GetMapping
  public ResponseEntity<List<CityDTO>> findAll(CityDTO dto) {
    List<CityDTO> result = service.findAll();
    return ResponseEntity.ok().body(result);
  }

  @PostMapping
  public ResponseEntity<CityDTO> insert(@RequestBody CityDTO dto) {
    CityDTO cityDTO = service.insert(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(cityDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(cityDTO);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<CityDTO> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}