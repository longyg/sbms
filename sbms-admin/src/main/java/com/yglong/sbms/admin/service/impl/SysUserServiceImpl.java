package com.yglong.sbms.admin.service.impl;

import com.yglong.sbms.admin.dao.SysUserMapper;
import com.yglong.sbms.admin.entity.SysUser;
import com.yglong.sbms.admin.service.SysUserService;
import com.yglong.sbms.common.utils.DateTimeUtils;
import com.yglong.sbms.common.utils.PoiUtils;
import com.yglong.sbms.core.page.MyBatisPageHelper;
import com.yglong.sbms.core.page.PageRequest;
import com.yglong.sbms.core.page.PageResult;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper mapper;

    @Override
    public int save(SysUser record) {
        return mapper.insert(record);
    }

    @Override
    public int delete(SysUser record) {
        return mapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysUser> records) {
        for (SysUser record : records) {
            mapper.deleteByPrimaryKey(record.getId());
        }
        return 1;
    }

    @Override
    public SysUser findById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MyBatisPageHelper.findPage(pageRequest, mapper);
    }

    @Override
    public File createUserExcelFile(PageRequest pageRequest) {
        PageResult pageResult = findPage(pageRequest);
        return createUserExcelFile(pageResult.getContent());
    }

    private static File createUserExcelFile(List<?> records) {
        if (null == records) {
            records = new ArrayList<>();
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row0 = sheet.createRow(0);
        int columnIndex = 0;
        row0.createCell(columnIndex).setCellValue("No");
        row0.createCell(++columnIndex).setCellValue("ID");
        row0.createCell(++columnIndex).setCellValue("用户名");
        row0.createCell(++columnIndex).setCellValue("昵称");
        row0.createCell(++columnIndex).setCellValue("机构");
        row0.createCell(++columnIndex).setCellValue("角色");
        row0.createCell(++columnIndex).setCellValue("邮箱");
        row0.createCell(++columnIndex).setCellValue("手机号");
        row0.createCell(++columnIndex).setCellValue("状态");
        row0.createCell(++columnIndex).setCellValue("头像");
        row0.createCell(++columnIndex).setCellValue("创建人");
        row0.createCell(++columnIndex).setCellValue("创建时间");
        row0.createCell(++columnIndex).setCellValue("最后更新人");
        row0.createCell(++columnIndex).setCellValue("最后更新时间");
        for (int i = 0; i < records.size(); i++) {
            SysUser user = (SysUser) records.get(i);
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < columnIndex + 1; j++) {
                row.createCell(j);
            }
            columnIndex = 0;
            row.getCell(columnIndex).setCellValue(i + 1);
            row.getCell(++columnIndex).setCellValue(user.getId());
            row.getCell(++columnIndex).setCellValue(user.getName());
            row.getCell(++columnIndex).setCellValue(user.getNickName());
            row.getCell(++columnIndex).setCellValue(user.getDeptId());
            row.getCell(++columnIndex).setCellValue(user.getDeptName());
            row.getCell(++columnIndex).setCellValue(user.getRoleNames());
            row.getCell(++columnIndex).setCellValue(user.getMobile());
            row.getCell(++columnIndex).setCellValue(user.getStatus());
            row.getCell(++columnIndex).setCellValue(user.getAvatar());
            row.getCell(++columnIndex).setCellValue(user.getCreateBy());
            row.getCell(++columnIndex).setCellValue(DateTimeUtils.getDateTime(user.getCreateTime()));
            row.getCell(++columnIndex).setCellValue(user.getLastUpdateBy());
            row.getCell(++columnIndex).setCellValue(DateTimeUtils.getDateTime(user.getLastUpdateTime()));
        }

        return PoiUtils.createExcelFile(workbook, "download_user");
    }
}
