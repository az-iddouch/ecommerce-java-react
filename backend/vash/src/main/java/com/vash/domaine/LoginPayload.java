package com.vash.domaine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LoginPayload implements Serializable {
    private static final long serialVersionUID = 1990636834341304493L;
    private String token;
    private Long id;
    private String fullName;
    private List<RoleVo> roles;
}
