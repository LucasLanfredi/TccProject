package com.TCCProject.TCCPROJECT.Repositories;

import com.TCCProject.TCCPROJECT.Entities.ResponsavelAndCrianca;
import com.TCCProject.TCCPROJECT.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ResponsavelAndCriancaRepository extends JpaRepository<ResponsavelAndCrianca, Long> {

    @Query("SELECT fk_crianca_ID FROM responsavel_crianca WHERE fk_responsavel_ID = ?1")
    Optional<List<Long>> findListCriancaByResponsavelID(Long responsavelID);

}
