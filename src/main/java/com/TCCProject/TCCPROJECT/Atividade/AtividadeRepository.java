package com.TCCProject.TCCPROJECT.Atividade;

import com.TCCProject.TCCPROJECT.Entities.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    Optional<List<Atividade>> findByResponsavelId(Long responsavelID);
}
