package com.TCCProject.TCCPROJECT.Recompensa;

import com.TCCProject.TCCPROJECT.Entities.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecompensaRepository extends JpaRepository<Recompensa, Long> {

    Optional<List<Recompensa>> findByResponsavelId(Long responsavelID);

}
