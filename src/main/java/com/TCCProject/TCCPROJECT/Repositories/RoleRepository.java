package com.TCCProject.TCCPROJECT.Repositories;

import java.util.Optional;

import com.TCCProject.TCCPROJECT.Entities.Role;
import com.TCCProject.TCCPROJECT.Models.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
