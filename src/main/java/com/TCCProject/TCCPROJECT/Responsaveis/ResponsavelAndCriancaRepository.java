package com.TCCProject.TCCPROJECT.Responsaveis;

import com.TCCProject.TCCPROJECT.Entities.ResponsavelAndCrianca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

interface ResponsavelAndCriancaRepository extends JpaRepository<ResponsavelAndCrianca, Long> {

    Optional<List<Long>> findByResponsavelId(Long responsavelID);

}
