package com.example.mentoringproject.login.email.handler;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Slf4j
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException {
    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/plain;charset=UTF-8");
    response.getWriter().write("로그인 실패! 이메일이나 비밀번호를 확인해주세요.");
    log.info("로그인에 실패했습니다. 메시지 : {}", exception.getMessage()); // 로그인이 실패하게 되면, Response Body에 로그인 실패 메세지를 띄우고 404 ERROR 코드를 반환
  }
}