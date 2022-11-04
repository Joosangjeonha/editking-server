package sogang.capstone.editking.user.application;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogang.capstone.editking.user.application.dto.UserIdDTO;
import sogang.capstone.editking.user.application.dto.oauth.UserInfoDTO;
import sogang.capstone.editking.user.domain.User;
import sogang.capstone.editking.user.domain.UserRepository;

@Service
@RequiredArgsConstructor
public class UserAuthenticationService {

    private final UserRepository userRepository;

    @Transactional
    public UserIdDTO loginWithUserInformation(UserInfoDTO userInfoDTO) {
        Optional<User> registeredUser = userRepository.findByAuthenticationCode(
            userInfoDTO.getAuthenticationCode());

        UserIdDTO userIdDTO;
        if (registeredUser.isPresent()) {
            userIdDTO = new UserIdDTO(registeredUser.get().getId());
        } else {
            User newUser = User.builder()
                .name(userInfoDTO.getName())
                .authenticationCode(userInfoDTO.getAuthenticationCode())
                .provider(userInfoDTO.getProvider())
                .refreshToken("")
                .build();
            userRepository.save(newUser);

            userIdDTO = new UserIdDTO(newUser.getId());
        }

        return userIdDTO;
    }

    @Transactional(readOnly = true)
    public void updateRefreshToken(UserIdDTO userIdDTO, String refreshToken) {
        User user = userRepository.findById(userIdDTO.getId());
        user.setNewRefreshToken(refreshToken);
    }
}
