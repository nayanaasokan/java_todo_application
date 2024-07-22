package com.todo.project.service;


import com.todo.project.dao.ProjectRepository;
import com.todo.project.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository theProjectRepository) {
        this.projectRepository = theProjectRepository;
    }


    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(int theId) {
        Optional<Project> result=projectRepository.findById(theId);
        Project theProject=null;
        if (result.isPresent()){
            theProject=result.get();
        }
        else{
            throw new RuntimeException("did not find project id "+theId);
        }
        return theProject;
    }

    @Override
    public Project save(Project theProject) {
        return projectRepository.save(theProject);
    }

    @Override
    public void deleteById(int theId) {
        projectRepository.deleteById(theId);

    }
}
