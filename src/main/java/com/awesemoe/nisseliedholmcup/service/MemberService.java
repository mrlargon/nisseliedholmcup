package com.awesemoe.nisseliedholmcup.service;

import com.awesemoe.nisseliedholmcup.model.Member;

import java.util.List;
import java.util.UUID;

public interface   MemberService {
    List<Member> listMembers();

    Member getMemberId(UUID id);

    Member saveMember(Member member);

    void updateMemberById(UUID memberId, Member member);

    public void remove(UUID memberId);

    void patchMemberById(UUID memberId, Member member);
}
