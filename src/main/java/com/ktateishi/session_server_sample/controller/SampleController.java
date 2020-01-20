package com.ktateishi.session_server_sample.controller;

import com.ktateishi.session_server_sample.model.entity.UserEntity;
import com.ktateishi.session_server_sample.model.form.UserForm;
import com.ktateishi.session_server_sample.service.SampleService;
import com.ktateishi.session_server_sample.symbol.Symbols;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@AllArgsConstructor
public class SampleController {

    private SampleService service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @ModelAttribute
    public UserForm setupForm() {
        return new UserForm();
    }


    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/login")
    public String login(@Validated UserForm form, BindingResult bindingResult,
                        HttpSession session, Model model) {

        // 入力チェックエラーが存在した場合はログイン画面を表示する
        if (bindingResult.hasErrors()) {
            return "index.html";
        }

        // ユーザ検索
        var user = service.findUser(form);

        if (user != null) {
            // ログイン成功
            // セッションにログインユーザを保管
            session.setAttribute(Symbols.SESSION_KEY, user);
        } else {
            // ログイン失敗
            model.addAttribute("loginError", "IDまたはパスワードが違います。");
            return "index.html";
        }

        model.addAttribute("user", user);

        return "output.html";
    }

    @RequestMapping("/output2")
    public String output2(HttpSession session, Model model) {
        // セッション情報取得
        var user = (UserEntity) session.getAttribute(Symbols.SESSION_KEY);
        model.addAttribute("user", user);
        log.info("セッションから{}さんを取得しました", user.getName());
        return "output2.html";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // セッション情報削除
        session.invalidate();
        return "index";
    }

}
