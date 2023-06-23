package com.project.AssignmentProject.service;

import com.project.AssignmentProject.domain.Assignment;
import com.project.AssignmentProject.domain.User;
import com.project.AssignmentProject.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment create(User user) {

        Assignment assignment = new Assignment();
        assignment.setStatus("Need to be Submitted");
        assignment.setUser(user);

        return assignmentRepository.save(assignment);
    }
}
