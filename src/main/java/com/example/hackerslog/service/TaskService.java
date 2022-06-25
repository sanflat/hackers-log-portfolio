package com.example.hackerslog.service;

import com.example.hackerslog.form.TaskForm;
import com.example.hackerslog.model.StatusModel;
import com.example.hackerslog.model.TaskModel;
import com.example.hackerslog.model.UserModel;
import com.example.hackerslog.repository.StatusRepository;
import com.example.hackerslog.repository.TaskRepository;
import com.example.hackerslog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    /**
     * タスク情報 Mapper
     */
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private UserRepository userRepository;

    public List<TaskForm> search(Integer projectId, TaskForm form) {
        return taskRepository.findByProjectId(projectId)
                .stream()
                .filter(task -> StringUtils.isEmpty(form.getTaskName())
                        || !StringUtils.isEmpty(form.getTaskName()) && task.getName().contains(form.getTaskName()))
                .filter(task -> form.getStatusId() == null
                        || form.getStatusId() != null && task.getStatusId() == form.getStatusId())
                .filter(task -> form.getUserId() == null
                        || form.getUserId() != null && task.getUserId() == form.getUserId())
                .map(task -> new TaskForm(
                        task.getId(),
                        task.getName(),
                        "",
                        task.getUserId(),
                        userRepository.findById(task.getUserId()).getName(),
                        task.getStatusId(),
                        statusRepository.findById(task.getStatusId()).getName(),
                        null,
                        null))
                .collect(Collectors.toList());
    }

    public List<UserModel> getUsersByProjectId(Integer projectId) {
        return taskRepository.findByProjectId(projectId)
                .stream()
                .map(task -> task.getUserId())
                .distinct()
                .map(id -> userRepository.findById(id))
                .collect(Collectors.toList());
    }

    public void create(Integer projectId, TaskForm form) {
        var minStatusId = statusRepository.findByProjectId(projectId)
                .stream()
                .map(status -> status.getId())
                .min(Comparator.naturalOrder());
        var current = new Date();

        TaskModel taskModel = new TaskModel();
        taskModel.setUserId(form.getUserId());
        taskModel.setProjectId(projectId);
        taskModel.setName(form.getTaskName());
        taskModel.setContents(form.getContents());
        taskModel.setStatusId(minStatusId.get());
        taskModel.setCreatedAt(current);
        taskModel.setUpdatedAt(current);

        taskRepository.create(taskModel);
    }

    public TaskForm get(Integer taskId) {
        var task = taskRepository.findByTaskId(taskId);
        var df = new SimpleDateFormat("yyyy/MM/dd");

        return new TaskForm(task.getId(),
                task.getName(),
                task.getContents(),
                task.getUserId(),
                userRepository.findById(task.getUserId()).getName(),
                task.getStatusId(),
                statusRepository.findById(task.getStatusId()).getName(),
                String.valueOf(df.format(task.getCreatedAt())),
                String.valueOf(df.format(task.getUpdatedAt())));
    }

    public Integer update(TaskForm form) {
        var taskModel = taskRepository.findByTaskId(form.getTaskId());
        var current = new Date();

        taskModel.setUserId(form.getUserId());
        taskModel.setName(form.getTaskName());
        taskModel.setContents(form.getContents());
        taskModel.setStatusId(form.getStatusId());
        taskModel.setUpdatedAt(current);

        taskRepository.update(taskModel);

        return taskModel.getProjectId();
    }
}
