package com.TCCProject.TCCPROJECT.Atividade;

import com.TCCProject.TCCPROJECT.Entities.CriancaAtividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

interface CriancaAtividadeRepository extends JpaRepository<CriancaAtividade, Long> {


    @Query(value = "SELECT fk_atividade_id FROM crianca_atividade WHERE fk_crianca_id = :criancaId AND status_atividade = 'ATIVA'", nativeQuery = true)
    Optional<List<Long>> findAtividadeIdByCriancaId(@Param("criancaId") Long criancaId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE crianca_atividade " +
            "SET status_atividade = :status " +
            "WHERE fk_atividade_id = :atividadeId AND fk_crianca_id = :criancaId", nativeQuery = true)
    void updateStatusByCriancaAndAtividadeId(@Param("status") String status, @Param("atividadeId") Long atividadeId,
                                             @Param("criancaId") Long criancaId);
    @Transactional
    @Modifying
    void deleteByAtividadeId(Long atividadeId);
}
