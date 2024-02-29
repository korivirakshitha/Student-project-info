package com.example.Studentprojectinfo.service;
import com.example.Studentprojectinfo.dto.Projectrequest;
import com.example.Studentprojectinfo.exception.UserNotFoundException;
import com.example.Studentprojectinfo.model.Project;
import com.example.Studentprojectinfo.repository.Projectrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Projectservice {
    @Autowired
    private Projectrepository repo;
    public Project saveproject(Projectrequest projectRequest) {

        Project project = new Project();

        project.setRollno(projectRequest.getRollno());
        project.setName(projectRequest.getName());
        project.setBatch(projectRequest.getBatch());
        project.setEmail(projectRequest.getEmail());
        project.setPhone(projectRequest.getPhone());
        project.setDepartment(projectRequest.getDepartment());
        project.setSemester(projectRequest.getSemester());
        project.setProjectname(projectRequest.getProjectname());
        project.setDescription(projectRequest.getDescription());
        project.setStatus(projectRequest.getStatus());
        project.setSupervisor(projectRequest.getSupervisor());
        project.setHodname(projectRequest.getHodname());
        project.setDate(projectRequest.getDate());
        project.setTopic(projectRequest.getTopic());
        project.setGithublink(projectRequest.getGithublink());
        project.setProjectlink(projectRequest.getProjectlink());
        return repo.save(project);
    }

    public List<Project> getALlProjects() {
        return repo.findAll();
    }

    public Project getProjectByRollno(String rollno) throws UserNotFoundException {
        Project p = repo.findByRollno(rollno);
        if(p != null){
            return p;
        } else {
            throw new UserNotFoundException("User not found with roll number: " + rollno);
        }
    }

}
