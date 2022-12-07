package com.TCCProject.TCCPROJECT.Recompensa;

import com.TCCProject.TCCPROJECT.Entities.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface RecompensaRepository extends JpaRepository<Recompensa, Long> {

    Optional<List<Recompensa>> findByResponsavelId(Long responsavelID);

}
