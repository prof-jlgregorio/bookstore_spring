package br.com.jlgregorio.bookstore.service;

import br.com.jlgregorio.bookstore.dto.AuthRequestDto;
import br.com.jlgregorio.bookstore.dto.AuthResponseDto;
import br.com.jlgregorio.bookstore.dto.RegisterDto;
import br.com.jlgregorio.bookstore.exception.DuplicatedUserNameException;
import br.com.jlgregorio.bookstore.model.RoleModel;
import br.com.jlgregorio.bookstore.model.UserModel;
import br.com.jlgregorio.bookstore.provider.TokenProvider;
import br.com.jlgregorio.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    public AuthResponseDto login(AuthRequestDto authRequest){
        var userNamePasswd = new UsernamePasswordAuthenticationToken(authRequest.userName(), authRequest.password());
        var auth = authenticationManager.authenticate(userNamePasswd);
        var token = tokenProvider.getToken((UserModel) auth.getPrincipal());
        return new AuthResponseDto(authRequest.userName(), token);
    }

    public UserModel register(RegisterDto registerData){
        var found = userDetailsService.loadUserByUsername(registerData.userName());
        if (found != null){
            throw new DuplicatedUserNameException("Nome de usuário indisponível!");
        } else {
            String encPasswd = new BCryptPasswordEncoder().encode(registerData.password());
            UserModel userModel = new UserModel();
            userModel.setFullName(registerData.fullName());
            userModel.setUserName(registerData.userName());
            //..encrypted password
            userModel.setPassword(encPasswd);
            userModel.setEnabled(true);
            userModel.setRole(RoleModel.USER);
            userModel.setAccountNonLocked(true);
            userModel.setCredentialsNonExpired(true);
            userModel.setAccountNonExpired(true);
            return userRepository.save(userModel);
        }
    }


}
