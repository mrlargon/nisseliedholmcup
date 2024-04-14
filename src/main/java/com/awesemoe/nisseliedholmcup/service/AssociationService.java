package com.awesemoe.nisseliedholmcup.service;

import com.awesemoe.nisseliedholmcup.model.Association;

import java.util.List;
import java.util.UUID;

public interface AssociationService {
    Association getAssociationId(UUID id);
    Association saveAssociation(Association association);

    List<Association> listAssociations();

    void updateAssociationById(UUID associationId, Association association);

    void patchById(UUID beerId, Association association);
}
