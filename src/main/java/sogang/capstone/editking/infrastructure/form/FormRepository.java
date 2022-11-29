package sogang.capstone.editking.infrastructure.form;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sogang.capstone.editking.domain.form.Form;
import sogang.capstone.editking.domain.form.FormStatus;
import sogang.capstone.editking.domain.user.User;

public interface FormRepository extends JpaRepository<Form, Long> {

    public Optional<Form> findById(Long id);

    public Form save(Form form);

    public void delete(Form form);

    @Query(value = "SELECT f FROM Form f WHERE f.user= :user AND f.status = :status ORDER BY f.dueDate ASC")
    public List<Form> findByUserAndStatusOrderByDueDateAsc(@Param("user") User user, @Param("status") FormStatus status,
            Pageable limit);
}
