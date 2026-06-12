package com.thiranx.data.dto;

public class Task {
    private Integer id;
    private String title;
    private String description;
    private String assignedBy;
    private String assignedTo;
    private Long createdTime;
    private Long dueDate;
    private Long completedTime;

    public Task() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAssignedBy() { return assignedBy; }
    public void setAssignedBy(String assignedBy) { this.assignedBy = assignedBy; }

    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }


    public Long getCreatedTime() { return createdTime; }
    public void setCreatedTime(Long createdTime) { this.createdTime = createdTime; }

    public Long getDueDate() { return dueDate; }
    public void setDueDate(Long dueDate) { this.dueDate = dueDate; }

    public Long getCompletedTime() { return completedTime; }
    public void setCompletedTime(Long completedTime) { this.completedTime = completedTime; }

}