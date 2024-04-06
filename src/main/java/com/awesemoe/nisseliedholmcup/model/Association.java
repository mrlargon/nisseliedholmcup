package com.awesemoe.nisseliedholmcup.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Builder
@Data
@ToString
public class Association {
    private UUID id;
    private Integer version;
    private String associationName;
    private String city;
    private String county;
    private String address;
    private String email;
}
