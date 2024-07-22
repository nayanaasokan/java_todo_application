package com.todo.project.service;

import com.todo.project.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();

    Project findById(int theId);

    Project save(Project theProject);

    void deleteById(int theId);






}
