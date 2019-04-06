package com.atguigu.springboot06.elastic.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Author:Dn
 * @Date:Create in 3:01 PM 2019/4/6
 * @Modifid By:
 */
@Data
@Accessors(chain =true)
public class Article {


    private Integer id;
    private String author;
    private String title;
    private String content;
}
