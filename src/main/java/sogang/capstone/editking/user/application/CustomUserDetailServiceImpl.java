package sogang.capstone.editking.user.application;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.user.domain.NoUserException;
import sogang.capstone.editking.user.domain.User;
import sogang.capstone.editking.user.domain.UserRepository;

@RequiredArgsConstructor
@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByIdOptional(Long.parseLong(username))
            .orElseThrow(() -> new NoUserException());
    }

    @Getter
    @ToString
    @EqualsAndHashCode
    public static class TokenDTO {

        private Long id;
        private String name;

        public TokenDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }
}
