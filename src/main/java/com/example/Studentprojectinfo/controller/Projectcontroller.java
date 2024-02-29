package com.example.Studentprojectinfo.controller;

import com.example.Studentprojectinfo.dto.Projectrequest;
import com.example.Studentprojectinfo.exception.UserNotFoundException;
import com.example.Studentprojectinfo.model.Project;
import com.example.Studentprojectinfo.service.Projectservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class Projectcontroller {
    @Autowired
    private Projectservice projectservice;

    @PostMapping("/addproject")
    public ResponseEntity<Project> saveproject(@RequestBody  @Valid Projectrequest projectRequest){
        return new ResponseEntity<>(projectservice.saveproject(projectRequest), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Project>> getallproject(){

        return ResponseEntity.ok(projectservice.getALlProjects());
    }
    @GetMapping("/{rollno}")
    public ResponseEntity<Project> getProjectByRollNo(@PathVariable String rollno) throws UserNotFoundException {
        return ResponseEntity.ok(projectservice.getProjectByRollno(rollno));
    }

}
