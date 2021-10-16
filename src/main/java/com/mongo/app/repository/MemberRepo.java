package com.mongo.app.repository;

import com.mongo.app.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anonymous
 * @version 1.0.0
 * @since 14 10 2021
 */
@Repository
public interface MemberRepo extends MongoRepository<Member, String> {

}
