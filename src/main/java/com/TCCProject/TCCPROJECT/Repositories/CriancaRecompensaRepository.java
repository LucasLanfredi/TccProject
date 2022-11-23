package com.TCCProject.TCCPROJECT.Repositories;

import com.TCCProject.TCCPROJECT.Entities.CriancaRecompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CriancaRecompensaRepository extends JpaRepository<CriancaRecompensa, Long> {

    @Query("SELECT fk_atividade_id FROM crianca_recompensa WHERE fk_crianca_id= ?1")
    Optional<List<Long>> findRecompensaIDByCriancaID(Long criancaID);

    @Query("SELECT id FROM crianca_recompensa WHERE fk_recompensa_id = ?1")
    Optional<List<Long>> findRelacionamentoWithRecompensaID(Long recompensaID);
}
