package com.yglong.sbms.admin.controller;

import com.yglong.sbms.admin.entity.SysDict;
import com.yglong.sbms.admin.service.SysDictService;
import com.yglong.sbms.core.http.HttpResult;
import com.yglong.sbms.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dict")
public class SysDictController {
    @Autowired
    private SysDictService sysDictService;

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDict record) {
        return HttpResult.ok(sysDictService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysDict> records) {
        return HttpResult.ok(sysDictService.delete(records));
    }

    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysDictService.findPage(pageRequest));
    }

    @PostMapping(value = "findByLabel")
    public HttpResult findByLabel(@RequestParam String label) {
        return HttpResult.ok(sysDictService.findByLabel(label));
    }
}
