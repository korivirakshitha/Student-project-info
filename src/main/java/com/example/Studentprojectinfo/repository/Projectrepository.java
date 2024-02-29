package com.example.Studentprojectinfo.repository;

import com.example.Studentprojectinfo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Projectrepository extends JpaRepository<Project,Integer> {
    Project findByRollno(String rollNo);
}
