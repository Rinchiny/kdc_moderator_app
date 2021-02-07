package ru.boost.charity.kdc_moderator_app.model;

import lombok.Data;

import java.util.Date;

@Data
public class TaskModel {

    private Long id;

    private String name;

    private String description;

    private String location;

    private String comment;

    private Long taskTypeId;

    private Long taskStatusId;

    private Long parentTaskId;

    private Long reporterId;

    private Long moderatorId;

    private Long executorId;

    private Date createDate;

    private Date updateDate;

    private Date expirationDate;

    private boolean isActive;
}
