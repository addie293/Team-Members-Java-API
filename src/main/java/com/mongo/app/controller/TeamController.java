package com.mongo.app.controller;

import com.mongo.app.model.Member;
import com.mongo.app.model.Team;
import com.mongo.app.services.TeamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping(path = "/teams", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTeam(@RequestBody Team team) {
        String result = teamService.createTeam(team);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateTeam(@RequestBody Team team) {
        String result = teamService.updateTeam(team);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateTeamWithMembers(@PathVariable String id, @RequestBody List<Member> members) {
        String result = teamService.updateTeamWithMembers(id, members);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getTeamWithKey(@PathVariable String id) {
        Team team = teamService.getTeamWithKey(id);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable String id) {
        boolean result = teamService.deleteTeam(id);
        String message = result ? "Team Deleted Successfully" : "Team does not exist";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
