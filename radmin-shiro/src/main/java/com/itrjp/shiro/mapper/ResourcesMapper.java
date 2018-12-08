package com.itrjp.shiro.mapper;


import com.itrjp.shiro.util.MyMapper;
import com.itrjp.shiro.model.Resources;

import java.util.List;
import java.util.Map;

public interface ResourcesMapper extends MyMapper<Resources> {

    public List<Resources> queryAll();

    public List<Resources> loadUserResources(Map<String, Object> map);

    public List<Resources> queryResourcesListWithSelected(Integer rid);
}