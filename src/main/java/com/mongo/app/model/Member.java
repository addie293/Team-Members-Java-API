package com.mongo.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Anonymous
 * @version 1.0.0
 * @since 14 10 2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "members")
public class Member {

    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String status;

    public Member(String email, String firstName, String lastName, String status) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

}
