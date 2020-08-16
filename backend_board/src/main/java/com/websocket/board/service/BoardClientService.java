package com.websocket.board.service;

import com.websocket.board.payload.LoginRequest;
import com.websocket.board.payload.LoginResponse;
import com.websocket.board.payload.ValidTokenRequest;
import com.websocket.board.payload.ValidTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardClientService {

    private final ApiService<LoginResponse> apiService;
    private final ApiService<ValidTokenResponse> tokenApiService;
    //private final ApiService<UserInfoResponse> userInfoResponseApiService;

    public LoginResponse callPostExternalServer(LoginRequest request) {
        return apiService.post("http://i3a510.p.ssafy.io:9004/api/auth/login", HttpHeaders.EMPTY, request, LoginResponse.class).getBody();
    }

    public ValidTokenResponse checkToken(ValidTokenRequest request) {
        return tokenApiService
                .post(
                        "http://i3a510.p.ssafy.io:9004/api/auth/login",
                        HttpHeaders.EMPTY,
                        request,
                        ValidTokenResponse.class)
                .getBody();
    }

//    public UserInfoResponse callPostUserInfoExternalServer(String token, String email) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer " + token);
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        //HttpEntity requestEntity =  new  HttpEntity(request, headers);
//
//        return userInfoResponseApiService.get("http://i3a510.p.ssafy.io:9004/api/user/userInfo?email=" + email, headers, UserInfoResponse.class).getBody();
//    }

}