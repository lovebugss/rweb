package com.itrjp.oauth.dao;


import com.itrjp.oauth.bean.Resource;

import java.util.List;


public interface ResourceDao {

    Resource createResource(Resource resource);

    Resource updateResource(Resource resource);

    void deleteResource(Long resourceId);

    Resource findOne(Long resourceId);

    List<Resource> findAll();

}
