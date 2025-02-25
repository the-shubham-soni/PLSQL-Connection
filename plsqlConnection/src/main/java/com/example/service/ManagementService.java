package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.ManagementRepository;

import java.util.List;


@Service
public class ManagementService {

    @Autowired
    private ManagementRepository managementRepository;

    public List<Object[]> getManagementDetails() {
        return managementRepository.processManagementShort();
    }

    public List<Object[]> getDevelopersByRole(String role) {
        return managementRepository.fetchDeveloperByRole(role);
    }
}

