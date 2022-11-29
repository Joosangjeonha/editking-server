package sogang.capstone.editking.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.domain.user.JwtTokenService;
import sogang.capstone.editking.domain.user.KakaoService;
import sogang.capstone.editking.domain.user.NaverService;
import sogang.capstone.editking.domain.user.UserAuthenticationService;

@Service
@RequiredArgsConstructor
public class UserAuthenticationFacade {

    private final KakaoService kakaoService;
    private final NaverService naverService;
    private final UserAuthenticationService userAuthenticationService;
    private final JwtTokenService jwtTokenService;
}
