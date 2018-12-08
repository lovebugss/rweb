package com.itrjp.rweb.service;

/**
 * Created by MAC on 2018/10/24.
 */

import com.itrjp.rweb.model.Foo;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SolrjService {

    // 定义http的solr服务
    @Autowired
    private SolrClient client;

    public SolrjService(SolrClient client) {
        this.client = client;
    }

    /**
     * 新增数据到solr服务
     *
     * @param foo
     * @throws Exception
     */
    public void add(Foo foo) throws Exception {
        //添加数据到solr服务器
        this.client.addBean(foo);
        //提交
        this.client.commit();
    }

    /**
     * 删除
     *
     * @param ids
     * @throws Exception
     */
    public void delete(List<String> ids) throws Exception {
        this.client.deleteById(ids);
        //提交
        this.client.commit();
    }

    /**
     * 更新
     *
     * @param foo
     * @throws Exception
     */
    public void update(Foo foo) throws Exception {
        this.client.deleteById(foo.getId());
        this.client.addBean(foo);
        this.client.commit();
    }

    /**
     * 搜索
     *
     * @param keywords 关键字
     * @param page     页
     * @param rows     行
     * @return
     * @throws Exception
     */
    public List<Foo> search(String keywords, Integer page, Integer rows) throws Exception {
        SolrQuery solrQuery = new SolrQuery(); //构造搜索条件
        solrQuery.setQuery(keywords); //搜索关键词
        // 设置分页 start=0就是从0开始，，rows=5当前返回5条记录，第二页就是变化start这个值为5就可以了。
        solrQuery.setStart((Math.max(page, 1) - 1) * rows);
        solrQuery.setRows(rows);

        //是否需要高亮
        boolean isHighlighting = !StringUtils.equals("*", keywords) && StringUtils.isNotEmpty(keywords);

        if (isHighlighting) {
            // 设置高亮
            solrQuery.setHighlight(true); // 开启高亮组件
            if (keywords.startsWith("tag"))
                solrQuery.addHighlightField("tag");// 高亮字段
            if (keywords.startsWith("title"))
            solrQuery.addHighlightField("title");// 高亮字段
            solrQuery.setHighlightSimplePre("<span style='color:red'>");// 标记，高亮关键字前缀
            solrQuery.setHighlightSimplePost("</span>");// 后缀
        }

        // 执行查询
        QueryResponse queryResponse = this.client.query(solrQuery);
        List<Foo> foos = queryResponse.getBeans(Foo.class);
        if (isHighlighting) {
            // 将高亮的标题数据写回到数据对象中
            Map<String, Map<String, List<String>>> map = queryResponse.getHighlighting();
            for (Map.Entry<String, Map<String, List<String>>> highlighting : map.entrySet()) {
                for (Foo foo : foos) {
                    if (!highlighting.getKey().equals(foo.getId().toString())) {
                        continue;
                    }
                    if (keywords.startsWith("title"))
                        foo.setTitle(StringUtils.join(highlighting.getValue().get("title"), ""));
                    if (keywords.startsWith("tag"))
                        foo.setTag(StringUtils.join(highlighting.getValue().get("tag"), ""));
                    break;
                }
            }
        }

        return foos;
    }

}
