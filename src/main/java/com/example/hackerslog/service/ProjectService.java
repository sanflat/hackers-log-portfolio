package com.example.hackerslog.service;

import com.example.hackerslog.form.ProjectForm;
import com.example.hackerslog.model.GroupUserModel;
import com.example.hackerslog.model.ProjectModel;
import com.example.hackerslog.model.UserModel;
import com.example.hackerslog.repository.GroupUserRepository;
import com.example.hackerslog.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * プロジェクト情報 Service
 */
@Service
@Transactional
public class ProjectService {

    /**
     * プロジェクト情報 Mapper
     */
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private GroupUserRepository groupUserRepository;
    @Autowired
    private UserService userService;

    public ProjectModel getProject(Integer projectId) {
        return projectRepository.findById(projectId);
    }

    public List<ProjectModel> getProjectList(String userName){
        UserModel userModel = userService.findName(userName);
        return projectRepository.findByProjectList(userModel.getId());
    }

    public void createProject(ProjectForm projectForm,String userName){
        ProjectModel projectModel = new ProjectModel();
        GroupUserModel groupUserModel = new GroupUserModel();
        UserModel userModel = userService.findName(userName);
        int maxId = groupUserRepository.findByMaxId();
        groupUserModel.setId(maxId + 1);
        groupUserModel.setUserId(userModel.getId());
        groupUserRepository.createGroupUser(groupUserModel);
        projectModel.setName(projectForm.getName());
        projectModel.setGroupUserId(maxId + 1);
        projectRepository.createProject(projectModel);
    }
}