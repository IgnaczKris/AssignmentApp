package com.project.AssignmentProject.controller;

import com.project.AssignmentProject.domain.Assignment;
import com.project.AssignmentProject.domain.User;
import com.project.AssignmentProject.service.AssignmentService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContext;

@RestController
@RequestMapping("/api/v1/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<?> createAssignment(@AuthenticationPrincipal User user){
        System.out.println("Success");

        Assignment newAssignment = assignmentService.create(user);

        return ResponseEntity.ok(newAssignment);
        //return ResponseEntity.ok().body(request.getHeader("jwt"));
    }

}
