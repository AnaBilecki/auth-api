package com.authapi.services;

import com.authapi.dto.user.UserRegisterRequestDTO;
import com.authapi.entities.user.User;
import com.authapi.exceptions.LoginAlreadyInUseException;
import com.authapi.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }

    public void register(UserRegisterRequestDTO dto) {
        if (repository.findByLogin(dto.getLogin()) != null) {
            throw new LoginAlreadyInUseException(dto.getLogin());
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
        dto.setPassword(encryptedPassword);
        repository.save(convertToEntity(dto));
    }

    private User convertToEntity(UserRegisterRequestDTO dto) {
        return modelMapper.map(dto, User.class);
    }
}
