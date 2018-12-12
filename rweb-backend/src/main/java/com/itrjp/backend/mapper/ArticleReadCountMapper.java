package com.itrjp.backend.mapper;


import com.itrjp.common.mapper.BaseMapper;
import com.itrjp.backend.model.ArticleReadCount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by MAC on 2018/10/22.
 */
@Mapper
public interface ArticleReadCountMapper extends BaseMapper<ArticleReadCount> {

    //    @Update("update article_read_count set read_count = #{readCount} where id = #{id}")
    int updateBath(@Param("list") List<ArticleReadCount> list);

    /**
     * 插入一条数据
     * @param id
     * @param readCount
     * @return
     */
    @Insert({"insert into article_read_count values(#{id},#{readCount,jdbcType=INTEGER})"})
    int insertOne(@Param("id") String id, @Param("readCount") Integer readCount);

    /**
     * 通过id查询阅读量
     * @param id
     * @return
     */
    @Select("select read_Count from article_read_count where id = #{id}")
    Integer selectReadCountById(@Param("id") String id);
}
