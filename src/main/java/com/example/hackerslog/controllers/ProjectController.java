package com.example.hackerslog.controllers;

import com.example.hackerslog.common.UserAuthClass;
import com.example.hackerslog.form.ProjectForm;
import com.example.hackerslog.form.UserForm;
import com.example.hackerslog.model.UserModel;
import com.example.hackerslog.model.ProjectModel;
import com.example.hackerslog.service.ProjectService;
import com.example.hackerslog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.isEmpty;

/**
 * プロジェクト Controller
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    UserAuthClass userAuthClass;

    /**
     * プロジェクト一覧画面を表示
     * @param model Model
     * @return project/list.html
     */
    @RequestMapping("list")
    public String projectList(@ModelAttribute ProjectForm projectForm, Model model){
        userAuthClass.getAuthModelAttribute(model);
        List<ProjectModel> projectList = projectService.getProjectList(model.getAttribute("userName").toString());
        model.addAttribute("projectForm",projectForm);
        model.addAttribute("projectList",projectList);
        return "project/list";
    }

    /**
     * プロジェクト登録
     * @param model Model
     * @return project/create.html
     */
    @PostMapping("create")
    public String projectCreate(@ModelAttribute ProjectForm projectForm, Model model){
        userAuthClass.getAuthModelAttribute(model);
        projectService.createProject(projectForm,model.getAttribute("userName").toString());
        return projectList(projectForm,model);
    }

    @RequestMapping("join")
    @ResponseBody
    public List<UserModel> findSelect2List(@RequestParam(value = "q", required = false) String query) {
        List<UserModel> userModelList = new ArrayList<>();
        if (isEmpty(query)){
            return userModelList.stream().toList();
        }
        userModelList = userService.findSelect2List(query);
        return userModelList.stream().toList();
    }
}
