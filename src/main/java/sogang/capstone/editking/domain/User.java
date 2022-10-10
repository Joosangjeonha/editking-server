package sogang.capstone.editking.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sogang.capstone.editking.constant.PlanStatus;
import sogang.capstone.editking.exception.BadRequestException;

@Getter
@Setter
@Entity
@Table(name = "User")
@NoArgsConstructor
@DynamicUpdate
@EqualsAndHashCode(of = "id")
public class User extends AbstractTimestamp implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(name = "authentication_code", nullable = false, unique = true)
    private String authenticationCode;

    @Column(nullable = false, length = 5)
    private String provider;

    @Column(columnDefinition = "TEXT")
    private String refreshToken;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @ColumnDefault("STANDARD")
    private PlanStatus plan;

    @OneToMany(mappedBy = "user")
    private List<Form> formList;

    @Builder
    public User(
        Long id,
        String name,
        String authenticationCode,
        String provider,
        String refreshToken,
        PlanStatus plan
    ) {
        if (name == null) {
            throw new BadRequestException("이름은 필수값입니다.");
        }
        if (authenticationCode == null) {
            throw new BadRequestException("인증 코드는 필수값입니다.");
        }
        if (provider == null) {
            throw new BadRequestException("provider는 필수값입니다.");
        }
        if (refreshToken == null) {
            throw new BadRequestException("refreshToken은 필수값입니다.");
        }
        if (plan == null) {
            throw new BadRequestException("plan은 필수값입니다.");
        }

        this.id = id;
        this.name = name;
        this.authenticationCode = authenticationCode;
        this.provider = provider;
        this.refreshToken = refreshToken;
        this.plan = plan;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() { return getName(); }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}