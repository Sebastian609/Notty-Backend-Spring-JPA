package com.notty.Notty.Aplication.Factory;

import com.notty.Notty.Domain.DTO.GenericTaskDTO;
import com.notty.Notty.Domain.DTO.PersonalTaskDTO;
import com.notty.Notty.Domain.DTO.TaskDTO;
import com.notty.Notty.Domain.DTO.TaskTeamDTO;

public class TaskFactory {
    public static TaskDTO createTask(GenericTaskDTO dto) {
        if ("TEAM".equalsIgnoreCase(dto.getType())) {
            TaskTeamDTO teamTask = new TaskTeamDTO();
            populateCommonFields(teamTask, dto);
            return teamTask;
        }
        if ("PERSONAL".equalsIgnoreCase(dto.getType())) {
            PersonalTaskDTO task = new PersonalTaskDTO();
            populateCommonFields(task, dto);
            task.setIdUserCreator(dto.getIdUserCreator());
            task.setUserOwner(dto.getUserOwner());
            return task;
        }
        return null;
    }

    private static void populateCommonFields(TaskDTO task, GenericTaskDTO dto) {
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setTimeLimit(dto.getTimeLimit());
        task.setActiveTask(dto.getActiveTask());

        if(dto.getCreaterAt()!=null){
            task.setCreaterAt(dto.getCreaterAt());
        }

        if(dto.getUpdatedAt()!=null){
            task.setUpdatedAt(dto.getUpdatedAt());
        }

        if(dto.getTaskStatus()!=null){
            task.setTaskStatus(dto.getTaskStatus());
        }
    }
}
