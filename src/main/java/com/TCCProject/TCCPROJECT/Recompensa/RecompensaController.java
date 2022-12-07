package com.TCCProject.TCCPROJECT.Recompensa;

import com.TCCProject.TCCPROJECT.Config.MessageResponse;
import com.TCCProject.TCCPROJECT.DTO.RecompensaDTO;
import com.TCCProject.TCCPROJECT.Entities.*;
import com.TCCProject.TCCPROJECT.Models.EStatusRecompensa;
import com.TCCProject.TCCPROJECT.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/recompensa")
public class RecompensaController {

    @Autowired
    RecompensaRepository recompensaRepository;
    
    @Autowired
    CriancaRecompensaRepository criancaRecompensaRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/criar")
    public ResponseEntity<?> criarRecompensa (@Valid @RequestBody RecompensaDTO RecompensaDTO){

        Recompensa recompensa = new Recompensa(RecompensaDTO.getNomeRecompensa(),
                RecompensaDTO.getDescricaoRecompensa(),
                RecompensaDTO.getPontuacaoRecompensa(),
                RecompensaDTO.getResponsavelId());

        Recompensa recompensaNew = recompensaRepository.save(recompensa);

        for(Long criancaID : RecompensaDTO.getCriancas()){
            criancaRecompensaRepository.save(new CriancaRecompensa(criancaID, recompensaNew.getId(), EStatusRecompensa.DISPONIVEL));
        }
        return ResponseEntity.ok(new MessageResponse("Recompensa cadastrada com sucesso"));
    }

    @PostMapping("/deletarRecompensa/{id}")
    public ResponseEntity<?> deletarRecompensa (@NotNull @PathVariable Long id){

        Recompensa recompensaExcluida = recompensaRepository.findById(id)
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada a recompensa: " + id));

        criancaRecompensaRepository.deleteByRecompensaId(id);
        recompensaRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Recompensa excluida com sucesso"));
    }

    @PostMapping("/editarRecompensa/{id}")
    public ResponseEntity<?> editarAtividade(@Valid @RequestBody RecompensaDTO recompensaDTO, @NotNull @PathVariable Long id){
        userRepository.findById(recompensaDTO.getResponsavelId())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado, ID : " + recompensaDTO.getResponsavelId()));

        Recompensa recompensaEditada = recompensaRepository.findById(id)
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada atividades"));

        recompensaEditada.setNomeRecompensa(recompensaDTO.getNomeRecompensa());
        recompensaEditada.setDescricaoRecompensa(recompensaDTO.getDescricaoRecompensa());
        recompensaEditada.setPontuacaoRecompensa(recompensaDTO.getPontuacaoRecompensa());


        recompensaRepository.save(recompensaEditada);
        return ResponseEntity.ok(new MessageResponse("Atividade editada com sucesso"));
    }

    @GetMapping("/listarCrianca/{id}")
    public ResponseEntity<List<Recompensa>> listarRecompensasCrianca(@NotNull @PathVariable Long id){

        List<Long> listaRecompensasIDs = criancaRecompensaRepository.findRecompensaDisponivelIdByCriancaId(id)
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada atividades"));

        List<Recompensa> listaRecompensas = new ArrayList<>();
        for (Long atividadeID: listaRecompensasIDs) {
            listaRecompensas.add(recompensaRepository.findById(atividadeID)
                    .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada recompensas")));
            }

        return ResponseEntity.ok(listaRecompensas);
    }

    @GetMapping("/listarAdulto/{id}")
    public ResponseEntity<List<Recompensa>> listarRecompensasAdulto(@NotNull @PathVariable Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado: " + id));

        List<Recompensa> listaRecompensas = recompensaRepository.findByResponsavelId(user.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada recompensas"));

        return ResponseEntity.ok(listaRecompensas);
    }

    @PostMapping("/resgatarRecompensa/{criancaId}/{id}")
    public ResponseEntity<?> realizarAtividade(@NotNull @PathVariable Long criancaId,  @NotNull @PathVariable Long id){
        User user = userRepository.findById(criancaId)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado: " + criancaId));

        Recompensa recompensaRealizada = recompensaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nao foi possivel encontrar a recompensa"));

        if(user.getPontuacaoUser() - recompensaRealizada.getPontuacaoRecompensa() < 0) {
            return ResponseEntity.ok(new MessageResponse("Sem pontos suficientes!"));
        }

        criancaRecompensaRepository.updateStatusByCriancaAndAtividadeId(EStatusRecompensa.RESGATADA.toString(),recompensaRealizada.getId(),
                user.getId());

        user.setNewPontuacaoUser(recompensaRealizada);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("Parabens, recompensa foi resgatada"));
    }

    @PostMapping("/reativarRecompensa/{criancaId}/{id}")
    public ResponseEntity<?> reativarAtividades(@NotNull @PathVariable Long criancaId,  @NotNull @PathVariable Long id){
        User user = userRepository.findById(criancaId)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado: " + criancaId));

        Recompensa recompensaRealizada = recompensaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nao foi possivel encontrar a recompensa"));

        criancaRecompensaRepository.updateStatusByCriancaAndAtividadeId(EStatusRecompensa.DISPONIVEL.toString(),recompensaRealizada.getId(),
                user.getId());

        return ResponseEntity.ok(new MessageResponse("recompensa foi reativa"));
    }
}
