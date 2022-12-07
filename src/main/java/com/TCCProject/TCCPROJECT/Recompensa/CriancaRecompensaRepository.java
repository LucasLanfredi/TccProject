package com.TCCProject.TCCPROJECT.Recompensa;

import com.TCCProject.TCCPROJECT.Entities.CriancaRecompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CriancaRecompensaRepository extends JpaRepository<CriancaRecompensa, Long> {

    Optional<List<Long>> findByCriancaId(Long criancaId);

    Optional<List<Long>> findByRecompensaId(Long recompensaId);

    @Transactional
    @Modifying
    @Query(value = "delete from crianca_recompensa WHERE fk_recompensa_id = :recompensaId ", nativeQuery = true)
    int deleteByRecompensaId(Long recompensaId);

    @Transactional
    @Query(value = "SELECT fk_recompensa_id FROM crianca_recompensa WHERE fk_crianca_id = :criancaId AND status_recompensa = 'DISPONIVEL'", nativeQuery = true)
    Optional<List<Long>> findRecompensaDisponivelIdByCriancaId(Long criancaId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE crianca_recompensa " +
            "SET status_recompensa = :status " +
            "WHERE fk_recompensa_id = :atividadeId AND fk_crianca_id = :criancaId", nativeQuery = true)
    void updateStatusByCriancaAndAtividadeId(String status, Long atividadeId, Long criancaId);
}
