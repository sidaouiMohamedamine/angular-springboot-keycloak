package com.sid.employeeManagementSystemBackend.controller;


import com.sid.employeeManagementSystemBackend.entity.Team;
import com.sid.employeeManagementSystemBackend.service.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/team/")
@RestController
public class TeamRestController {

    @Autowired
    private TeamServiceImpl teamService;


    @PostMapping("addTeam")
    public Team addTeam(@RequestBody Team team)  {
        return teamService.addTeam(team);
    }
    @GetMapping("getTeam")
    public List<Team> getAllTeam(){
        return teamService.getAllTeam();
    }
    @GetMapping("getTeamById")
    public Team getTeamById(Long id){
        return teamService.getTeamById(id);
    }
    @PutMapping("updateTeam/{id}")
    public Team updateTeam(@PathVariable("id")Long id,@RequestBody Team team){
        return  teamService.updateTeam(id,team);
    }

    @DeleteMapping("deleteTeam/{id}")
    public String deleteTeam(@PathVariable("id") Long id){
        return teamService.deleteTeam(id);
    }


}
