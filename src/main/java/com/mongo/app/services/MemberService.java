package com.mongo.app.services;

import com.mongo.app.model.Member;
import java.util.List;

/**
 *
 * @author Anonymous
 * @version 1.0.0
 * @since 14 10 2021
 */
public interface MemberService {

    /**
     * Create a new member in the mongo database.
     *
     * @param mem
     * @return
     */
    public String createMember(Member mem);

    /**
     * Update an existing member in the mongo database.
     *
     * @param mem
     * @return
     */
    public String updateMember(Member mem);

    /**
     * Fetch all members from the mongo database.
     *
     * @return
     */
    public List<Member> getAllMembers();

    /**
     * Fetch a particular member from the mongo database using it key.
     *
     * @param id Key in the Document referencing the particular memeber.
     * @return
     */
    public Member getMemberWithKey(String id);

}
