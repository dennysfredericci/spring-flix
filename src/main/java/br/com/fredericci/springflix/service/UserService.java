package br.com.fredericci.springflix.service;

import br.com.fredericci.springflix.domain.UserDetailsImpl;
import br.com.fredericci.springflix.domain.UserEntity;
import br.com.fredericci.springflix.repository.UserRepository;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService, AuditorAware<UserEntity> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @PostConstruct
    public void createDefaultUser() {
        final UserEntity userEntity = new UserEntity();
        userEntity.setName("Dennys Fredericci");
        userEntity.setEmail("dennys@fredericci.com");
        userEntity.setPassword(passwordEncoder.encode("123"));
        userRepository.save(userEntity);
    }

    @Override
    public Optional<UserEntity> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(user -> userRepository.findByEmail(user.getUsername()).orElse(null));
    }
}
