package com.pennant.prodmtr.model.Input;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.pennant.prodmtr.model.Entity.Project;
import com.pennant.prodmtr.model.Entity.ProjectTask;
import com.pennant.prodmtr.model.Entity.User;

public class ProjectTaskInput {
	private int taskId;
	private int assignedUserId;
	private String taskName;
	private String taskCreationDateTime;
	private String taskCategory;
	private String taskDescription;
	private int taskCreatorId;
	private BigDecimal numberOfHoursRequired;
	private String taskExpectedDateTime;
	private int projectId;

	// Getters and setters
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getAssignedUserId() {
		return assignedUserId;
	}

	public void setAssignedUserId(int assignedUserId) {
		this.assignedUserId = assignedUserId;
	}

	public int getprojectId() {
		return projectId;
	}

	public void setprojectId(int projectId) {
		this.projectId = projectId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskCreationDateTime() {
		return taskCreationDateTime;
	}

	public void setTaskCreationDateTime(String taskCreationDateTime) {
		this.taskCreationDateTime = taskCreationDateTime;
	}

	public String getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public int getTaskCreatorId() {
		return taskCreatorId;
	}

	public void setTaskCreatorId(int taskCreatorId) {
		this.taskCreatorId = taskCreatorId;
	}

	public BigDecimal getNumberOfHoursRequired() {
		return numberOfHoursRequired;
	}

	public void setNumberOfHoursRequired(BigDecimal numberOfHoursRequired) {
		this.numberOfHoursRequired = numberOfHoursRequired;
	}

	public String getTaskExpectedDateTime() {
		return taskExpectedDateTime;
	}

	public void setTaskExpectedDateTime(String taskExpectedDateTime) {
		this.taskExpectedDateTime = taskExpectedDateTime;
	}

	public ProjectTask toEntity() {
		ProjectTask projectTask = new ProjectTask();
		projectTask.setTaskId(this.taskId);

		User user = new User();
		user.setUserId(this.assignedUserId);
		projectTask.setAssignedUser(user);

		projectTask.setTaskName(this.taskName);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date utilDate = dateFormat.parse(this.taskCreationDateTime);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			projectTask.setTaskCreationDateTime(sqlDate);
		} catch (ParseException e) {
			// Custom error handling for parse exception
			System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
			e.printStackTrace();
		}
		// projectTask.setTaskCreationDateTime(this.taskCreationDateTime);
		projectTask.setTaskCategory(this.taskCategory);
		projectTask.setTaskDescription(this.taskDescription);

		User user2 = new User();
		user2.setUserId(this.taskCreatorId);
		projectTask.setTaskCreator(user2);
		projectTask.setNumberOfHoursRequired(this.numberOfHoursRequired);
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date utilDate = dateFormat2.parse(this.taskExpectedDateTime);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			projectTask.setTaskExpectedDateTime(sqlDate);
		} catch (ParseException e) {
			// Custom error handling for parse exception
			System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
			e.printStackTrace();
		}
		// projectTask.setTaskExpectedDateTime(this.taskExpectedDateTime);
		Project project = new Project();
		project.setProjectId((short) this.projectId);
		projectTask.setproject(project);

		return projectTask;
	}
}