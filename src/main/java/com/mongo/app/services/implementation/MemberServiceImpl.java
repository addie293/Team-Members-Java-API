package com.mongo.app.services.implementation;

import com.mongo.app.model.Member;
import com.mongo.app.repository.MemberRepo;
import com.mongo.app.services.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anonymous
 * @version 1.0.0
 * @since 14 10 2021
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepo memberDB;

    @Override
    public String createMember(Member mem) {
        Member saved = memberDB.insert(mem);
        return "Member " + saved.getFirstName() + " created successfully";
    }

    @Override
    public String updateMember(Member mem) {
        Member updated = memberDB.save(mem);
        return "Member " + updated.getFirstName() + " updated successfully";
    }

    @Override
    public List<Member> getAllMembers() {
        return memberDB.findAll();
    }

    @Override
    public Member getMemberWithKey(String id) {
        return memberDB.findById(id).get();
    }

}
