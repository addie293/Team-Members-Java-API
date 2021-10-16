package com.mongo.app;

import com.mongo.app.model.Member;
import com.mongo.app.model.Team;
import com.mongo.app.services.MemberService;
import com.mongo.app.services.TeamService;
import static com.mongodb.assertions.Assertions.assertFalse;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class TeamsMemberApplicationTests {

    @Autowired
    private MemberService memberService;

    @Autowired
    private TeamService teamService;

    private static Member member;
    private static Member memberZ;
    private static Team team;
    private static Team teamZ;
    private static List<Member> members;

    @BeforeAll
    static void init() {
        members = new ArrayList<>();
        member = new Member("testA@gmail.com", "Tester", "A", "frontend");
        memberZ = new Member("testZ@gmail.com", "Tester", "Z", "backend");
        team = new Team("Team A", members);
        teamZ = new Team("Team Z", members);
    }

    @Test
    @Order(1)
    void testCreateMember() {
        //Test if the result provided is same after creation done
        assertEquals("Member " + member.getFirstName() + " created successfully", memberService.createMember(member));
    }

    @Test
    @Order(2)
    void testFetchMembers() {
        //Fetch all members from mongodb to check if is empty or not
        assertFalse(memberService.getAllMembers().isEmpty()); //Need to be true for the test to validated because the test up has created a member
    }

    @Test
    @Order(3)
    void testUpdateMembers() {
        Member toUpdate = memberService.getAllMembers().get(0);
        toUpdate.setFirstName("Tester Updated");
        //Test if the result provided is same after updating the member
        assertEquals("Member " + toUpdate.getFirstName() + " updated successfully", memberService.updateMember(toUpdate));
    }

    @Test
    @Order(4)
    void testCreateTeam() {
        //Test if the result provided is same after creation done
        Assertions.assertAll(
                () -> assertEquals(team.getName() + " created successfully", teamService.createTeam(team)),
                () -> assertEquals(teamZ.getName() + " created successfully", teamService.createTeam(teamZ))
        );
    }

    @Test
    @Order(5)
    void testFetchTeams() {
        //Fetch all teams from mongodb to check if is empty or not
        assertFalse(teamService.getAllTeams().isEmpty()); //Need to be true for the test to validated because the test up has created a team hence
    }

    @Test
    @Order(6)
    void testUpdateTeam() {
        Team toUpdate = teamService.getAllTeams().get(0);
        assertEquals(toUpdate.getName() + " updated successfully", teamService.updateTeam(toUpdate));
    }

    @Test
    @Order(7)
    void testAddMemberToTeam() {
        Team toUpdate = teamService.getAllTeams().get(1); //fetch the first team in the mongo db
        members.add(memberZ); // add member Z to the list of members
        String id = toUpdate.getId();
        assertEquals(toUpdate.getName() + " added members successfully", teamService.updateTeamWithMembers(id, members));
    }

    @Test
    @Order(8)
    void testDeleteTeam() {
        Team toDelete = teamService.getAllTeams().get(0); //fetch the first team in the mongo db
        assertEquals(true, teamService.deleteTeam(toDelete.getId())); //true if the team has been deleted
    }
}
