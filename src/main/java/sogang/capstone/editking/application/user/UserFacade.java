package sogang.capstone.editking.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.domain.user.UserService;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

}