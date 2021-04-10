package com.vash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vash.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Long>{

    Role findByRole(String client);
}
