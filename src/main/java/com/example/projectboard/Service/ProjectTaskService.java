package com.example.projectboard.Service;

import com.example.projectboard.Model.ProjectTask;
import com.example.projectboard.Repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public Iterable<ProjectTask> getAllProjectTasks() {
        return projectTaskRepository.findAll();
    }

    public ProjectTask findById(Long id) {
        return projectTaskRepository.getById(id);
    }

    public ProjectTask createOrUpdateTask(ProjectTask projectTask) {
        if (projectTask.getStatus() == null || projectTask.getStatus() == "") {
            projectTask.setStatus("TO_DO");
        }
        return projectTaskRepository.save(projectTask);
    }

    public void deleteById(Long id) {
        ProjectTask projectTask = findById(id);
        projectTaskRepository.delete(projectTask);
    }
}


