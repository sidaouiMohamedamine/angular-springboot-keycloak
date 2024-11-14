package com.sid.employeeManagementSystemBackend.service;

import com.sid.employeeManagementSystemBackend.entity.Team;

import java.util.List;

public interface ITeamService {

    public Team addTeam(Team team);
    public List<Team> getAllTeam();
    public Team getTeamById(Long id);
    public Team updateTeam(Long id, Team team);
    public String deleteTeam(Long id);

}
