package com.vash.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.vash.dao.IUserRepository;
import com.vash.domaine.LoginPayload;
import com.vash.domaine.RoleConverter;
import com.vash.domaine.RoleVo;
import com.vash.domaine.UserConverter;
import com.vash.domaine.UserVo;
import com.vash.entities.User;
import com.vash.exceptions.UsernameException;
import com.vash.security.JwtTokenProvider;
import com.vash.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public LoginPayload login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            User user = iUserRepository.findByUserName(username);
            String token = jwtTokenProvider.createToken(username, user.getRoles(), user.getId());
            return LoginPayload.builder().token(token).
                    fullName(user.getFirstName() + " " + user.getLastName())
                    .id(user.getId())
                    .roles(RoleConverter.toListVo(user.getRoles())).build();
        } catch (AuthenticationException e) {
            throw new UsernameException("Invalid username/password supplied");
        }
    }



    @Override
    public LoginPayload register(UserVo userVo) {
        User userTemp = iUserRepository.findByUserName(userVo.getUserName());
        if (userTemp != null) {
            throw new UsernameException("Username already exists !");
        }
        RoleVo clientRole = roleService.findByRole("CLIENT");
        userVo.getRoles().add(clientRole);
        userVo.setPassword(bCryptPasswordEncoder.encode(userVo.getPassword()));
        User user = iUserRepository.save(UserConverter.toBo(userVo));
        @SuppressWarnings("unused")
		String token = jwtTokenProvider.createToken(user.getUserName(), user.getRoles(), user.getId());
        return LoginPayload.builder().id(user.getId())

                .fullName(user.getFirstName() + " " + user.getLastName())
                .roles(RoleConverter.toListVo(user.getRoles())).build();

    }

    @Override
    public List<UserVo> findAll() {
        return UserConverter.toListVo(iUserRepository.findAll());
    }

    @Override
    public UserVo findByUserNameAndPassword(String userName, String password) {

        return UserConverter.toVo(iUserRepository.findByUserNameAndPassword(userName, password));
    }

    @Override
    public UserVo findById(Long id) {
        Optional<User> UserOptional = iUserRepository.findById(id);
        UserVo userVo = new UserVo();
        if (UserOptional.isPresent()) {
            userVo = UserConverter.toVo(UserOptional.get());
        }
        return userVo;
    }

    @Override
    public boolean deleteById(Long id) {
        boolean checked = true;
        iUserRepository.deleteById(id);
        UserVo userVo = findById(id);
        if (!ObjectUtils.isEmpty(userVo)) {
            checked = true;
        }
        return checked;
    }

	@Override
	public UserVo findByUserName(String userName) {
		return UserConverter.toVo(iUserRepository.findByUserName(userName));
	}

}
