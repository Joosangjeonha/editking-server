package sogang.capstone.editking.user.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import sogang.capstone.editking.user.domain.User;
import sogang.capstone.editking.user.domain.UserRepository;

@Repository
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findByIdOptional(Long id) {
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public Optional<User> findByAuthenticationCode(String authenticationCode) {
        List<User> user = entityManager.createQuery(
                "select u from User u where u.authenticationCode = :authenticationCode", User.class)
            .setParameter("authenticationCode", authenticationCode)
            .getResultList();
        return user.stream().findAny();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

}
