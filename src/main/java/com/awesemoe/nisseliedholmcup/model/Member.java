package com.awesemoe.nisseliedholmcup.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;
@Builder
@Data
@ToString
public class Member {
    private UUID id;
    private Integer version;
    private String surName;
    private String familyName;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;
    private MemberTyp memberTyp;
    private LocalDateTime registerDate;
    private LocalDateTime updatedDate;

}
