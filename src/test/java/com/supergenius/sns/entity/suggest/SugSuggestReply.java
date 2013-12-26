package com.supergenius.sns.entity.suggest;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SugSuggestReply implements Serializable{
    private int id;
    private int cusId;
    private int suggestId;
    private String content;
    private int type;
    private int isbest;
    private java.util.Date addtime;
}
