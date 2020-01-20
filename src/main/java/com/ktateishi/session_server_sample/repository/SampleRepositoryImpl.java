package com.ktateishi.session_server_sample.repository;

import com.ktateishi.session_server_sample.model.entity.UserEntity;
import com.ktateishi.session_server_sample.model.form.UserForm;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class SampleRepositoryImpl implements SampleRepository {

    @Override
    //　本来であればDBに接続するべきだが、今回はDBに接続したつもりで実装
    public UserEntity selectUser(UserForm form) {
        var entity = new UserEntity();
        if ("100".equals(form.getId()) && "password".equals(form.getPassword())) {
            entity.setId(form.getId());
            entity.setName("佐藤");
            log.info("佐藤さんが見つかりました。");
        } else if ("101".equals(form.getId()) && "password".equals(form.getPassword())) {
            entity.setId(form.getId());
            entity.setName("鈴木");
            log.info("鈴木さんが見つかりました。");
        } else if ("102".equals(form.getId()) && "password".equals(form.getPassword())) {
            entity.setId(form.getId());
            entity.setName("高橋");
            log.info("高橋さんが見つかりました。");
        } else {
            entity = null;
            log.warn("見つかりませんでした。");
        }
        return entity;
    }

}
