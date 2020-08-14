package com.yglong.sbms.admin.service;

import com.yglong.sbms.admin.entity.SysDict;
import com.yglong.sbms.core.service.CurdService;

import java.util.List;

public interface SysDictService extends CurdService<SysDict> {

    List<SysDict> findByLabel(String label);

}
