package com.mongo.app.model;

import java.util.List;
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
@Document(collection = "teams")
public class Team {

    @Id
    private String id;
    private String name;
    private List<Member> members;

    public Team(String name, List<Member> members) {
        this.name = name;
        this.members = members;
    }
}
