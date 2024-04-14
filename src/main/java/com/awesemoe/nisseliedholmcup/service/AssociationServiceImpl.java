package com.awesemoe.nisseliedholmcup.service;

import com.awesemoe.nisseliedholmcup.model.Association;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Slf4j
@Service
public class AssociationServiceImpl implements AssociationService {


    Map<UUID, Association> associationMap;

    public AssociationServiceImpl() {
        this.associationMap = new HashMap<>();

        Association association1 = Association.builder()
                .id(UUID.randomUUID())
                .version(1).associationName("Sunnersta AIF")
                .address("Rälsvägen 32 , 123 45 Uppsala")
                .city("Uppsala")
                .county("Uppland")
                .email("saif@email.com")
                .build();
        Association association2 = Association.builder()
                .id(UUID.randomUUID())
                .version(1)
                .associationName("Valdemarsvik IF")
                .address("Rälsvägen 32 , 123 45 Valdemarsvik")
                .city("Valdemarsvik")
                .county("Östergötland")
                .email("wif@email.com")
                .build();
        Association association3 = Association.builder()
                .id(UUID.randomUUID())
                .version(1)
                .associationName("Heby IF")
                .address("Hedeby 32 , 123 45 Hedeby")
                .city("Hedeby")
                .county("Västermanland")
                .email("hif@email.com")
                .build();

        associationMap.put(association1.getId(), association1);
        associationMap.put(association2.getId(), association2);
        associationMap.put(association3.getId(), association3);

    }

    @Override
    public Association getAssociationId(UUID id) {

        return associationMap.get(id);
    }

    @Override
    public List<Association> listAssociations() {
        return new ArrayList<>(associationMap.values());
    }

    @Override
    public void updateAssociationById(UUID associationId, Association association) {
        Association existing = associationMap.get(associationId);
        if (existing != null) {
            existing.setAssociationName(association.getAssociationName());
            existing.setCity(association.getCity());
            existing.setEmail(association.getEmail());
            existing.setCounty(association.getCounty());
            associationMap.put(associationId, existing);
        }

    }

    @Override
    public void patchById(UUID associationId, Association association) {
        Association existing = associationMap.get(associationId);
        if (StringUtils.hasText(existing.getAssociationName())) {
            existing.setAssociationName(association.getAssociationName());
        }
        if (StringUtils.hasText(existing.getCity())) {
            existing.setCity(association.getCity());
        }
        if (StringUtils.hasText(existing.getEmail())) {
            existing.setEmail(association.getEmail());
        }
        if (StringUtils.hasText(existing.getCounty())) {
            existing.setCounty(association.getCounty());

        }
    }

    @Override
    public Association saveAssociation(Association association) {
        log.info("Registrera  förening {}", association);
        Association saveAssociation = Association.builder()
                .id(UUID.randomUUID())
                .version(1).associationName(association.getAssociationName())
                .address(association.getAddress())
                .city(association.getCity())
                .county(association.getCounty())
                .email(association.getEmail())
                .build();

        associationMap.put(saveAssociation.getId(), saveAssociation);
        return saveAssociation;
    }
}
