package com.awesemoe.nisseliedholmcup.controller;

import com.awesemoe.nisseliedholmcup.model.Association;
import com.awesemoe.nisseliedholmcup.service.AssociationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/association")
public class AssociationController {
    public static final String API_V_1_ASSOCIATION = "/api/v1/association";
    private final AssociationService associationService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Association> listAssociation() {
        return associationService.listAssociations();
    }

    @RequestMapping(value = "{associationId}", method = RequestMethod.GET)

    public Association getAssociationId(@PathVariable("associationId") UUID id) {
        log.debug("Get association by id - in controller id");
        return associationService.getAssociationId(id);
    }
    @PostMapping
    public ResponseEntity handlePost(@RequestBody Association association  ) {
        Association saveAssociation = associationService.saveAssociation(association);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", API_V_1_ASSOCIATION + saveAssociation.getId().toString());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);

    }

}
