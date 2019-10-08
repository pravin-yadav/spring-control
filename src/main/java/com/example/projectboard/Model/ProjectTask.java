package com.example.projectboard.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "task")
public class ProjectTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TaskId")
    private long id;

    @Column(name = "summary")
    @NotBlank(message = "Summary cannot be blank.")
    private String summary;

    @Column(name = "acceptanceCriteria")
    private String acceptanceCriteria;

    @Column(name = "status")
    private String status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
