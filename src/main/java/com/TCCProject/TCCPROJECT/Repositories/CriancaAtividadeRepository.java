package com.TCCProject.TCCPROJECT.Repositories;

import com.TCCProject.TCCPROJECT.Entities.CriancaAtividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CriancaAtividadeRepository extends JpaRepository<CriancaAtividade, Long> {

    @Query("SELECT fk_atividade_id FROM crianca_atividade WHERE fk_crianca_id= ?1")
    Optional<List<Long>> findAtividadeIDByCriancaID(Long criancaID);

    @Query("SELECT id FROM crianca_atividade WHERE fk_atividade_id = ?1")
    Optional<List<Long>> findRelacionamentoWithAtividadeID(Long atividadeID);
}
