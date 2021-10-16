package com.mongo.app.services.implementation;

import com.mongo.app.model.Member;
import com.mongo.app.model.Team;
import com.mongo.app.repository.TeamRepo;
import com.mongo.app.services.TeamService;
import java.util.ArrayList;
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
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepo teamDB;

    @Override
    public String createTeam(Team team) {
        Team saved = teamDB.insert(team);
        return saved.getName() + " created successfully";
    }

    @Override
    public String updateTeam(Team team) {
        Team updated = teamDB.save(team);
        return updated.getName() + " updated successfully";
    }

    @Override
    public String updateTeamWithMembers(String teamId, List<Member> members) {
        Team toUpdated = teamDB.findById(teamId).get();
        if (toUpdated.getMembers() == null) {
            toUpdated = new Team(toUpdated.getId(), toUpdated.getName(), new ArrayList<>());
        }
        toUpdated.getMembers().addAll(members);
        Team updated = teamDB.save(toUpdated);
        return updated.getName() + " added members successfully";
    }

    @Override
    public List<Team> getAllTeams() {
        return teamDB.findAll();
    }

    @Override
    public Team getTeamWithKey(String id) {
        return teamDB.findById(id).get();
    }

    @Override
    public boolean deleteTeam(String id) {
        try {
            teamDB.deleteById(id);
            return true;
        } catch (Exception e) {
            System.err.println("Team with Id => " + id + " already deleted");
            return false;
        }

    }
}
