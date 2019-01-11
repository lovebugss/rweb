package com.itrjp.radmin.dao;


import com.itrjp.common.mapper.BaseMapper;
import com.itrjp.radmin.bean.Resources;

import java.util.List;
import java.util.Map;

public interface ResourcesMapper extends BaseMapper<Resources> {

     List<Resources> queryAll();

     List<Resources> loadUserResources(Map<String, Object> map);

     List<Resources> queryResourcesListWithSelected(Integer rid);
}