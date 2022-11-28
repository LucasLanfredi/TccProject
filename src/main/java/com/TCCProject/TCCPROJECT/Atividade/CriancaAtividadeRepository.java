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

    Optional<List<Long>> findByCriancaId(Long criancaID);

    Optional<List<Long>> findByAtividadeId(Long atividadeID);

//    @Query("FROM crianca_atividade WHERE fk_atividade_id = ?1 AND fk_usuario_id = ?2")
//    List<CriancaAtividade> findAllByAtividadeID(long atividadeID, Long criancaID);
//
    @Transactional
    @Modifying
    @Query(value = "UPDATE crianca_atividade " +
            "SET atividade_status = :status " +
            "WHERE fk_atividade_id = :atividadeId AND fk_crianca_id = :criancaId", nativeQuery = true)
    void updateStatusByCriancaAndAtividadeId(@Param("status") String status, @Param("atividadeId") Long atividadeId,
                                             @Param("criancaId") Long criancaId);

}
