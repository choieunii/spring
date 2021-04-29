package com.hello.book.springboot.config.auth;

import com.hello.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
// 스프링 시큐리티 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()// h2-console화면을 사용하기 위해 해당 옵션들을 disable한다
                .and()
                .authorizeRequests()// URL별 권한관리를 설정하는 옵션의 시작점 얘가 설정되어야 andMatchers 사용가능
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll() // 권한부여
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())//해당 API는 USER 권한 가진 사람만 가능
                .anyRequest().authenticated()//설정된 값들 이외의 나머지 URL 인증된 사용자만 허용 가능
                .and()
                .logout()
                .logoutSuccessUrl("/")// 로그아웃시 이동
                .and()
                .oauth2Login()//OAuth 로그인 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint()//로그인 이후 사용자 정보를 가져올 때의 설정들을 담당한다.
                .userService(customOAuth2UserService); //로그인 성공후 후속조치
    }
}
