package com.ktateishi.session_server_sample.model.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
public class UserForm {
    @Pattern(regexp = "\\d{3}", message = "半角数字3桁で入力してください。")
    @Size(min = 3, max = 3, message = "3桁で入力してください。")
    private String id;
    private String password;
}
