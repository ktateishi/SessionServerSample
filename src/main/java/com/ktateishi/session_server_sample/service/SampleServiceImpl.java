package com.ktateishi.session_server_sample.service;

import com.ktateishi.session_server_sample.model.entity.UserEntity;
import com.ktateishi.session_server_sample.model.form.UserForm;
import com.ktateishi.session_server_sample.repository.SampleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SampleServiceImpl implements SampleService {

    private SampleRepository repository;

    @Override
    public UserEntity findUser(UserForm form) {
        return repository.selectUser(form);
    }
}
