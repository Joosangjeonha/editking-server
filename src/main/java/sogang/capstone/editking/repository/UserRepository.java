package sogang.capstone.editking.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import sogang.capstone.editking.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findById(Long id);

}
