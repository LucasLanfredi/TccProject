package com.TCCProject.TCCPROJECT.Repositories;

import com.TCCProject.TCCPROJECT.Entities.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RecompensaRepository extends JpaRepository<Recompensa, Long> {

    Optional<List<Recompensa>> findByAdultoID(Long responsavelID);

    @Query("DELETE FROM recompensas WHERE id = ?1 AND fk_responsavel_id = ?2")
    void deleteById(Long RecompensaID, Long responsavelID);
}
