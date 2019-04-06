package com.atguigu.springboot06.repository;

import com.atguigu.springboot06.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Description:
 * @Author:Dn
 * @Date:Create in 4:54 PM 2019/4/6
 * @Modifid By:
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    public List<Book> findBookByBookNameLike(String bookName);
}
