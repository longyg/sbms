package com.yglong.sbms.admin.service.impl;

import com.yglong.sbms.admin.constants.SysConstants;
import com.yglong.sbms.admin.dao.SysMenuMapper;
import com.yglong.sbms.admin.entity.SysMenu;
import com.yglong.sbms.admin.service.SysMenuService;
import com.yglong.sbms.core.page.MyBatisPageHelper;
import com.yglong.sbms.core.page.PageRequest;
import com.yglong.sbms.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findByUser(String username) {
        if (null == username || "".equals(username) || SysConstants.ADMIN.equalsIgnoreCase(username)) {
            return sysMenuMapper.findAll();
        }
        return sysMenuMapper.findByUsername(username);
    }

    @Override
    public int save(SysMenu record) {
        return sysMenuMapper.insert(record);
    }

    @Override
    public int delete(SysMenu record) {
        return sysMenuMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysMenu> records) {
        for (SysMenu record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysMenu findById(Long id) {
        return sysMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MyBatisPageHelper.findPage(pageRequest, sysMenuMapper);
    }
}
