package com.supergenius.sns.entity.blog;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BlogBlog implements Serializable{
    private int id;
    private int cusId;
    private String content;
    private int type;
    private int status;
    private int viewcount;
    private int replycount;
    private int isbest;
    private int activity;
    private java.util.Date addtime;
}
