package com.sid.employeeManagementSystemBackend.service;

import com.sid.employeeManagementSystemBackend.entity.Team;
import com.sid.employeeManagementSystemBackend.exception.NotFoundException;
import com.sid.employeeManagementSystemBackend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements ITeamService{

    @Autowired
    private TeamRepository teamRepository;


    @Override
    public Team addTeam(Team team) {

        return teamRepository.save(team);
    }

    @Override
    public List<Team> getAllTeam() {

        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Team Not Found"));
        return team;

    }

    @Override
    public Team updateTeam(Long id, Team team) {
        Team existingTeam = teamRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Team Not Found"));
        if (existingTeam != null) {
            existingTeam.setName(team.getName());
            existingTeam.setDescription(team.getDescription());

            return teamRepository.save(existingTeam);
        } else {
            return null;
        }
    }

    @Override
    public String deleteTeam(Long id) {

        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
            return "Team with Id " + id + " has been deleted successfully.";
        } else {
            return "Team with Id " + id + " not found.";
        }
    }





}
