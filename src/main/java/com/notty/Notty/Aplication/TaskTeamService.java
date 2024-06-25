package com.notty.Notty.Aplication;


import com.notty.Notty.DataAccess.TaskTeamRepository;
import com.notty.Notty.Domain.TaskEntity;
import com.notty.Notty.Domain.TeamTaskEntity;
import org.springframework.stereotype.Service;

@Service
public class TaskTeamService {
    private final TaskTeamRepository taskTeamRepository;

    public TaskTeamService(TaskTeamRepository taskTeamRepository) {
        this.taskTeamRepository = taskTeamRepository;
    }
    public TeamTaskEntity save(TeamTaskEntity task){
        return this.taskTeamRepository.save(task);
    }




}
