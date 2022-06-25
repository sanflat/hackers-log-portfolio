package com.example.hackerslog.controllers;

import com.example.hackerslog.common.UserAuthClass;
import com.example.hackerslog.form.TaskForm;
import com.example.hackerslog.model.ProjectModel;
import com.example.hackerslog.model.StatusModel;
import com.example.hackerslog.model.TaskModel;
import com.example.hackerslog.model.UserModel;
import com.example.hackerslog.service.ProjectService;
import com.example.hackerslog.service.StatusService;
import com.example.hackerslog.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * タスク Controller
 */
@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    ProjectService projectService;
    @Autowired
    StatusService statusService;
    @Autowired
    UserAuthClass userAuthClass;

    /**
     * タスク一覧
     * @param projectId Project ID
     * @param taskForm 検索 Form
     * @param model Model
     * @return タスク一覧
     */
    @GetMapping("list")
    public String list(
            @RequestParam("projectId") Integer projectId,
            @ModelAttribute TaskForm taskForm,
            Model model
    ) {
        userAuthClass.getAuthModelAttribute(model);

        ProjectModel myProject = projectService.getProject(projectId);
        model.addAttribute("myProject", myProject);

        model.addAttribute("taskForm", taskForm);

        List<UserModel> users = taskService.getUsersByProjectId(projectId);
        model.addAttribute("users", users);

        List<StatusModel> statusList = statusService.getStatusList(projectId);
        model.addAttribute("statusList", statusList);

        List<TaskForm> tasks = taskService.search(projectId, taskForm);
        model.addAttribute("tasks", tasks);

        return "task/list";
    }

    /**
     * タスク新規登録
     * @param projectId Project ID
     * @param taskForm 登録 Form
     * @param model Model
     * @return タスク一覧
     */
    @PostMapping("create")
    public String create(@RequestParam("projectId") Integer projectId,
                         @ModelAttribute TaskForm taskForm,
                         Model model
    ) {
        userAuthClass.getAuthModelAttribute(model);

        taskService.create(projectId, taskForm);

        TaskForm searchForm = new TaskForm();
        return list(projectId, searchForm, model);
    }

    /**
     * タスク詳細
     * @param projectId Project ID
     * @param taskId Task ID
     * @param model Model
     * @return タスク詳細
     */
    @GetMapping("view")
    public String view(@RequestParam("projectId") Integer projectId,
                       @RequestParam("taskId")Integer taskId,
                       Model model
    ) {
        userAuthClass.getAuthModelAttribute(model);

        TaskForm task = taskService.get(taskId);
        model.addAttribute("taskForm", task);

        ProjectModel myProject = projectService.getProject(projectId);
        model.addAttribute("myProject", myProject);

        List<UserModel> users = taskService.getUsersByProjectId(projectId);
        model.addAttribute("users", users);

        List<StatusModel> statusList = statusService.getStatusList(projectId);
        model.addAttribute("statusList", statusList);

        return "task/view";
    }

    /**
     * タスク編集
     * @param taskForm 編集 Form
     * @param model Model
     * @return タスク詳細
     */
    @PostMapping("edit")
    public String edit(@ModelAttribute TaskForm taskForm,
                       Model model
    ) {
        userAuthClass.getAuthModelAttribute(model);

        Integer projectId = taskService.update(taskForm);

        return view(projectId, taskForm.getTaskId(), model);
    }
}
