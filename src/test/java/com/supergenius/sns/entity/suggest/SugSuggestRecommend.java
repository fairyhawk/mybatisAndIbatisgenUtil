package com.supergenius.sns.entity.suggest;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SugSuggestRecommend implements Serializable{
    private int id;
    private int cusId;
    private int suggestId;
    private int type;
    private int score;
    private java.util.Date addtime;
}
