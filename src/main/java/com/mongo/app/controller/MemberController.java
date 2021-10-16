package com.mongo.app.controller;

import com.mongo.app.model.Member;
import com.mongo.app.services.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Anonymous
 * @version 1.0.0
 * @since 14 10 2021
 */
@RestController
@RequestMapping(path = "/members", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createMember(@RequestBody Member mem) {
        String result = memberService.createMember(mem);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMember(@RequestBody Member mem) {
        String result = memberService.updateMember(mem);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getMemberWithKey(@PathVariable String id) {
        Member member = memberService.getMemberWithKey(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
