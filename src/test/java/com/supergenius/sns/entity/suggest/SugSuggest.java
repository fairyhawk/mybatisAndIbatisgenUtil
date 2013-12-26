package com.supergenius.sns.entity.suggest;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SugSuggest implements Serializable{
    private int id;
    private int cusId;
    private String content;
    private int type;
    private int status;
    private int wisdomscore;
    private int hotscore;
    private int replycount;
    private java.util.Date addtime;
}
