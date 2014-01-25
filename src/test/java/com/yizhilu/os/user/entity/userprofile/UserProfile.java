package com.yizhilu.os.user.entity.userprofile;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserProfile implements Serializable{
    private Long id;
    private String name;
    private String value;
    private String profiletype;
    private Long userid;
    private java.util.Date profiledate;
}
