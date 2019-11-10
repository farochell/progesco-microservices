package com.progesco.progescoadmin.service;

import com.progesco.progescoadmin.repository.RoleRepository;
import com.progesco.progescoadmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author emile.camara
 * @date 01/11/2019
 */
@Service("AdminService")
public class AdminService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Value("${app.jwtSecret}")
    private String jwtSecret;
}
