package com.supergenius.sns.entity.blog;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BlogReply implements Serializable{
    private int id;
    private int cusId;
    private int blogId;
    private String content;
    private java.util.Date addtime;
}
