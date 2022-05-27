package com.jys7622.myapp.VO;



import java.sql.Timestamp;

import lombok.Data;



@Data
public class PostVO {

    private String id;
    private String categoryId;
    private String title;
    private String content;
    private String userId;
    private Timestamp regDate;

    

}