package com.TCCProject.TCCPROJECT.Repositories;

import com.TCCProject.TCCPROJECT.Entities.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    Optional<List<Atividade>> findByAdultoID(Long responsavelID);

    @Query("DELETE FROM atividades WHERE id = ?1 AND fk_responsavel_id = ?2")
    void deleteById(Long atividadeID, Long responsavelID);
}
