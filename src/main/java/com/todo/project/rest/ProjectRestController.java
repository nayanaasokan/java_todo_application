package com.todo.project.rest;


import com.todo.project.entity.Project;
import com.todo.project.entity.Todo;
import com.todo.project.service.ProjectService;
import com.todo.project.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectRestController {

    private ProjectService projectService;

    @Autowired
    public ProjectRestController(ProjectService theProjectService) {
        this.projectService = theProjectService;
    }

    @GetMapping("/project")
    public List<Project> findAll(){
        return projectService.findAll();
    }

    @GetMapping("/project/{projectId}")
    public Project getProject(@PathVariable int projectId){
        Project theProject=projectService.findById(projectId);
        if (theProject==null){
            throw new RuntimeException("project id not found "+projectId);
        }
        return theProject;
    }

    @PostMapping("/project")
    public Project addProject(@RequestBody Project theProject){
        theProject.setId(0);
        Project dbProject=projectService.save(theProject);
        return dbProject;
    }

    @PutMapping("/project")
    public Project updateProject(@RequestBody Project theProject){
        Project dbProject=projectService.save(theProject);
        return dbProject;
    }

    @DeleteMapping("/project/{projectId}")
    public String deleteProject(@PathVariable int projectId){
        Project tempProject=projectService.findById(projectId);
        if (tempProject==null){
            throw new RuntimeException("project id not found - "+projectId);
        }
        projectService.deleteById(projectId);
        return "deleted project id - "+projectId;
    }



}
