package com.itrjp.radmin.dao;

import com.itrjp.radmin.bean.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ren on 2018/11/4.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

}
