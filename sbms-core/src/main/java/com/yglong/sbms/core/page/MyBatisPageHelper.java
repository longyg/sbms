package com.yglong.sbms.core.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yglong.sbms.common.utils.ReflectionUtils;

import java.util.List;

public class MyBatisPageHelper {
    public static final String FIND_PAGE = "findPage";

    public static PageResult findPage(PageRequest pageRequest, Object mapper) {
        return findPage(pageRequest, mapper, FIND_PAGE);
    }

    public static PageResult findPage(PageRequest pageRequest, Object mapper,
                                      String queryMethodName, Object... args) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);
        return getPageResult(pageRequest, new PageInfo<Object>((List) result));

    }

    private static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
