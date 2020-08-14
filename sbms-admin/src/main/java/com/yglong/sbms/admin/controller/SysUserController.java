package com.yglong.sbms.admin.controller;

import com.yglong.sbms.admin.service.SysUserService;
import com.yglong.sbms.common.utils.FileUtils;
import com.yglong.sbms.core.http.HttpResult;
import com.yglong.sbms.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService service;

    @PostMapping(value = "findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(service.findPage(pageRequest));
    }

    @PostMapping(value = "/exportExcelUser")
    public void exportUser(@RequestBody PageRequest pageRequest, HttpServletResponse res) {
        File file = service.createUserExcelFile(pageRequest);
        FileUtils.downloadFile(res, file, file.getName());
    }
}
