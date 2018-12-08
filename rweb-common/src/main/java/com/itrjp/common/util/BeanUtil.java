package com.itrjp.common.util;

import com.github.pagehelper.Page;
import com.itrjp.common.result.PagedResult;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * bean工具类
 */


public class BeanUtil {

    public static <T> PagedResult<T> toPagedResult(List<T> datas) {
        PagedResult<T> result = new PagedResult<T>();
        if (datas instanceof Page) {
            Page page = (Page) datas;
            result.setPageNumber(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setDataList(page.getResult());
            result.setTotal(page.getTotal());
            result.setPages(page.getPages());
        } else {
            result.setPageNumber(1);
            result.setPageSize(datas.size());
            result.setDataList(datas);
            result.setTotal(datas.size());
        }

        return result;
    }

    public static <T> T copyProperties(Object source, Class<T> target) {

        try {
            T t = target.newInstance();
            BeanUtils.copyProperties(source, t);
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> copyProperties(List source, Class<T> clazz) {
        List<T> list = null;
        try {
            list = new ArrayList<T>();
            for (Object obj : source) {
                T t = clazz.newInstance();
                BeanUtils.copyProperties(obj, t);
                list.add(t);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;

    }
}
