package com.awesemoe.nisseliedholmcup.service;

import com.awesemoe.nisseliedholmcup.model.Member;
import com.awesemoe.nisseliedholmcup.model.MemberTyp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
    Map<UUID, Member> memberMap;

    @Override
    public List<Member> listMembers() {
         return new ArrayList<>(memberMap.values());
    }
    public MemberServiceImpl() {
        this.memberMap = new HashMap<>();


        Member member1 = Member.builder()
                .id(UUID.randomUUID())
                .version(1)
                .surName("Ove")
                .familyName("Bring")
                .address("Gatan 12")
                .city("Stockholm")
                .memberTyp(MemberTyp.ACTIV)
                .email("bring@epost.se")
                .registerDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        Member member2 = Member.builder()
                .id(UUID.randomUUID())
                .version(1)
                .surName("Rutker")
                .familyName("Jöns")
                .address("Norrgatan 12")
                .city("Stockholm")
                .memberTyp(MemberTyp.ACTIV)
                .email("jopns@epost.se")
                .registerDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        memberMap.put(member1.getId(), member1);
        memberMap.put(member2.getId(), member2);
    }

    @Override
    public Member getMemberId(UUID id) {
        return memberMap.get(id);
    }

    @Override
    public Member saveMember(Member member) {
        Member saveMember = Member.builder()
                .id(UUID.randomUUID())
                .version(1)
                .surName(member.getSurName())
                .familyName(member.getFamilyName())
                .address(member.getAddress())
                .city(member.getCity())
                .memberTyp(MemberTyp.ACTIV)
                .email(member.getEmail())
                .registerDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        memberMap.put(saveMember.getId(), saveMember);

        return saveMember;
    }

    @Override
    public void updateMemberById(UUID memberId, Member member) {
        Member existing = memberMap.get(memberId);
        if (existing != null) {
            existing.setSurName(member.getSurName());
            existing.setFamilyName(member.getFamilyName());
            existing.setAddress(member.getAddress());
            existing.setCity(member.getCity());
            existing.setMemberTyp(member.getMemberTyp());
            existing.setEmail(member.getEmail());
            existing.setUpdatedDate(LocalDateTime.now());
            memberMap.put(existing.getId(), existing);
        }
    }


    @Override
    public void remove(UUID memberId) {
        memberMap.remove(memberId);
    }

    @Override
    public void patchMemberById(UUID memberId, Member member) {
        Member existing = memberMap.get(memberId);
        if (StringUtils.hasText(existing.getFamilyName())) {
            existing.setFamilyName(member.getFamilyName());
        }
        if (StringUtils.hasText(existing.getSurName())) {
            existing.setSurName(member.getSurName());
        }
        if (StringUtils.hasText(existing.getSurName())) {
            existing.setSurName(member.getSurName());
        }
        if (StringUtils.hasText(existing.getAddress())) {
            existing.setAddress(member.getAddress());
        }
        if (StringUtils.hasText(existing.getCity())) {
            existing.setCity(member.getCity());
        }
        if (StringUtils.hasText(existing.getEmail())) {
            existing.setEmail(member.getEmail());
        }
        log.info("Updated {}" ,existing );

    }
}
