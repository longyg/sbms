package com.yglong.sbms.core.service;

import com.yglong.sbms.core.page.PageRequest;
import com.yglong.sbms.core.page.PageResult;

import java.util.List;

public interface CurdService<T> {
    int save(T record);

    int delete(T record);

    int delete(List<T> records);

    T findById(Long id);

    PageResult findPage(PageRequest pageRequest);
}
