package kea.dilemmaspilbackend.admin.controller;

import kea.dilemmaspilbackend.admin.model.AdminUser;
import kea.dilemmaspilbackend.admin.service.AdminUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class AdminController {
    private AdminUserService adminUserService;

    @GetMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestBody AdminUser adminUser) {
        adminUserService.login(adminUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
