package com.mongo.app.services;

import com.mongo.app.model.Member;
import com.mongo.app.model.Team;
import java.util.List;

/**
 *
 * @author Anonymous
 * @version 1.0.0
 * @since 14 10 2021
 */
public interface TeamService {

    /**
     * Create a new team in the mongo database.
     *
     * @param team
     * @return
     */
    public String createTeam(Team team);

    /**
     * Update an existing team in the mongo database.
     *
     * @param team
     * @return
     */
    public String updateTeam(Team team);

    /**
     * Update an existing team, adding members to the team in the mongo
     * database.
     *
     * @param teamId
     * @param members Members to add to the team
     * @return
     */
    public String updateTeamWithMembers(String teamId, List<Member> members);

    /**
     * Fetch all teams from the mongo database.
     *
     * @return
     */
    public List<Team> getAllTeams();

    /**
     * Fetch a particular team from the mongo database using it key.
     *
     * @param id Key in the Document referencing the particular team.
     * @return
     */
    public Team getTeamWithKey(String id);

    /**
     * Delete a partcular team using it key
     *
     * @param id Key in the Document referencing the particular team.
     * @return
     */
    public boolean deleteTeam(String id);
}
