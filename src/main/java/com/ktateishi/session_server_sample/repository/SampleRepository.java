package com.ktateishi.session_server_sample.repository;


import com.ktateishi.session_server_sample.model.entity.UserEntity;
import com.ktateishi.session_server_sample.model.form.UserForm;

public interface SampleRepository {
    UserEntity selectUser(UserForm form);
}
