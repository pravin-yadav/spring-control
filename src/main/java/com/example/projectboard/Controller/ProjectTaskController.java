package com.example.projectboard.Controller;

import com.example.projectboard.Model.ProjectTask;
import com.example.projectboard.Service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProjectTaskController {

    @Autowired
    private ProjectTaskService projectTaskService;

    @PostMapping("/createTask")
    public ResponseEntity<?> addTask(@Valid @RequestBody ProjectTask projectTask) {
        ProjectTask createTask = projectTaskService.createOrUpdateTask(projectTask);
        return new ResponseEntity<>(createTask, HttpStatus.CREATED);
    }

    @GetMapping("/task")
    public Iterable<ProjectTask> getAllTasks() {
        return projectTaskService.getAllProjectTasks();
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<?> getTaskById(@PathVariable Long taskId) {
        ProjectTask getTaskById = projectTaskService.findById(taskId);
        return new ResponseEntity<>(getTaskById, HttpStatus.OK);
    }

    @PutMapping("/updateTask/{taskId}")
    public ResponseEntity<?> updateTask(@PathVariable Long taskId, @Valid @RequestBody ProjectTask projectTask) {
        ProjectTask foundById = projectTaskService.findById(taskId);
        if (foundById != null) {
            foundById.setSummary(projectTask.getSummary());
            foundById.setAcceptanceCriteria(projectTask.getAcceptanceCriteria());
            foundById.setStatus(projectTask.getStatus());
            ProjectTask updatedTask = projectTaskService.createOrUpdateTask(foundById);
            return new ResponseEntity<>(updatedTask, HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Id doesn't exist!!!", HttpStatus.NOT_MODIFIED);
        }

    }

    @DeleteMapping("/deleteTask/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        projectTaskService.deleteById(taskId);
        return new ResponseEntity<>(String.format("Task Id %d deleted successfully!!", taskId), HttpStatus.OK);
    }
}
