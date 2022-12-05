package sogang.capstone.editking.domain.user.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sogang.capstone.editking.domain.user.NoUserException;
import sogang.capstone.editking.domain.user.UserReader;

@RequiredArgsConstructor
@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

    private final UserReader userReader;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userReader.findById(Long.parseLong(username))
                .orElseThrow(() -> new NoUserException());
    }
}
