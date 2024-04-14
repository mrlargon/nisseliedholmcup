package com.awesemoe.nisseliedholmcup.controller;

import com.awesemoe.nisseliedholmcup.model.Member;
import com.awesemoe.nisseliedholmcup.service.AssociationService;
import com.awesemoe.nisseliedholmcup.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/member")
public class MemberController {
    public static final String API_V_1_MEMBER = "/api/v1/member";
    private final MemberService memberService;

    @PatchMapping("{memberId}")
    public ResponseEntity updateBeerPatchById(@PathVariable("memberId") UUID memberId, @RequestBody Member member) {
        log.info("Uppdatera beer through patch  " + member);
        memberService.patchMemberById(memberId,member);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Member> listMembers() {
        return memberService.listMembers();
    }

    @RequestMapping(value = "{memberId}", method = RequestMethod.GET)
    public Member getCustomerById(@PathVariable("memberId") UUID id) {
        log.debug("Get memberId by is - in controller id {}",id);
        return memberService.getMemberId(id);
    }


}
