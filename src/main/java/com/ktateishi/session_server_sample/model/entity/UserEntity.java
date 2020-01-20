package com.ktateishi.session_server_sample.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class UserEntity implements Serializable {
    private String id;
    private String name;
}
