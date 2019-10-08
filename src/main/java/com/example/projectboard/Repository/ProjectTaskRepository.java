package com.example.projectboard.Repository;

import com.example.projectboard.Model.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
    ProjectTask getById(Long id);
}
