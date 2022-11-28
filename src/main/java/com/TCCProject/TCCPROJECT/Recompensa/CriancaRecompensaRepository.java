package com.TCCProject.TCCPROJECT.Recompensa;

import com.TCCProject.TCCPROJECT.Entities.CriancaRecompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CriancaRecompensaRepository extends JpaRepository<CriancaRecompensa, Long> {

    Optional<List<Long>> findByCriancaId(Long criancaID);

    Optional<List<Long>> findByRecompensaId(Long recompensaID);
}
