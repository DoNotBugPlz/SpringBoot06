package com.atguigu.springboot06.elastic.bean;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Description:
 * @Author:Dn
 * @Date:Create in 4:55 PM 2019/4/6
 * @Modifid By:
 */
@Document(indexName = "atguigu",type = "books")
@Data
@Accessors(chain =true)
public class Book {
    private Integer id;
    private String bookName;
    private String author;
}
