package com.example.hackerslog.service;

import com.example.hackerslog.model.StatusModel;
import com.example.hackerslog.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {
    /**
     * ステータス情報 Mapper
     */
    @Autowired
    private StatusRepository statusRepository;

    public List<StatusModel> getStatusList(Integer projectId) {
        return new ArrayList<>(statusRepository.findByProjectId(projectId));
    }
}
