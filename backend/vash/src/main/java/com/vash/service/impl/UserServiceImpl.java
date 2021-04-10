package com.vash.service.impl;

import java.util.List;
import java.util.Optional;

import com.vash.domaine.RoleVo;
import com.vash.exceptions.UsernameException;
import com.vash.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.vash.dao.IUserRepository;
import com.vash.domaine.UserConverter;
import com.vash.domaine.UserVo;
import com.vash.entities.User;
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

    public String login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            User user = iUserRepository.findByUserName(username);
            return jwtTokenProvider.createToken(username, user.getRoles(), user.getId());
        } catch (AuthenticationException e) {
            throw new UsernameException("Invalid username/password supplied");
        }
    }

    @Override
    public String save(UserVo userVo) {
        User userTemp = iUserRepository.findByUserName(userVo.getUserName());
        if (userTemp != null) {
            throw new UsernameException("Username already exists !");
        }
        RoleVo clientRole = roleService.findByRole("CLIENT");
        userVo.getRoles().add(clientRole);
        userVo.setPassword(bCryptPasswordEncoder.encode(userVo.getPassword()));
        User user = iUserRepository.save(UserConverter.toBo(userVo));
        return jwtTokenProvider.createToken(user.getUserName(), user.getRoles(), user.getId());
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

}
