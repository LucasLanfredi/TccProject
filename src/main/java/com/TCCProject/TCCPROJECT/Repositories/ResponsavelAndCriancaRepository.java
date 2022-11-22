package com.TCCProject.TCCPROJECT.Repositories;

import com.TCCProject.TCCPROJECT.Entities.ResponsavelAndCrianca;
import com.TCCProject.TCCPROJECT.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResponsavelAndCriancaRepository extends JpaRepository<ResponsavelAndCrianca, Long> {

    Optional<List<User>> findListCriancaByResponsavelID(ResponsavelAndCrianca responsavelID);

}
