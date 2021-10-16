package com.mongo.app.repository;

import com.mongo.app.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anonymous
 * @version 1.0.0
 * @since 14 10 2021
 */
@Repository
public interface TeamRepo extends MongoRepository<Team, String> {

}
