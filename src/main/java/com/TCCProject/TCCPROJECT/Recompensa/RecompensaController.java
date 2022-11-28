package com.TCCProject.TCCPROJECT.Recompensa;

import com.TCCProject.TCCPROJECT.Config.MessageResponse;
import com.TCCProject.TCCPROJECT.DTO.RecompensaDTO;
import com.TCCProject.TCCPROJECT.DTO.UserDTO;
import com.TCCProject.TCCPROJECT.Entities.*;
import com.TCCProject.TCCPROJECT.Models.EStatusRecompensa;
import com.TCCProject.TCCPROJECT.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
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

    @PostMapping("/criarRecompensa")
    public ResponseEntity<?> criarRecompensa (@NotNull UserDTO userDTO, @NotNull RecompensaDTO RecompensaDTO){
        User adulto = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario Responsavel nao Encontrado " + userDTO.getUsername()));

        Recompensa recompensa = new Recompensa(RecompensaDTO.getNomeRecompensa(),
                RecompensaDTO.getDescricaoRecompensa(),
                RecompensaDTO.getPontuacaoRecompensa(),
                adulto.getId());

        Long recompensaID = recompensaRepository.save(recompensa).getId();

        for(Long criancaID : RecompensaDTO.getCriancas()){
            User Crianca = userRepository.findById(criancaID)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario nao Encontrado. ID: " + criancaID));
            criancaRecompensaRepository.save(new CriancaRecompensa(Crianca.getId(), recompensaID, EStatusRecompensa.DISPONIVEL));
        }
        return ResponseEntity.ok(new MessageResponse("Recompensa cadastrada com sucesso"));
    }

    @PostMapping("/deletarRecompensa")
    public ResponseEntity<?> deletarRecompensa (@NotNull UserDTO userDTO, @NotNull RecompensaDTO recompensaDTO){
        userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario Responsavel nao Encontrado: " + userDTO.getUsername()));

        Recompensa recompensaExcluida = recompensaRepository.findById(recompensaDTO.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada a recompensa: " + recompensaDTO.getNomeRecompensa()));

        recompensaRepository.deleteById(recompensaDTO.getId());
        List<Long> listaDeRecompensas = criancaRecompensaRepository.findByRecompensaId(recompensaExcluida.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada a recompensa: " + recompensaDTO.getNomeRecompensa()));;

        for(Long recompensaID : listaDeRecompensas){
            criancaRecompensaRepository.deleteById(recompensaID);
        }

        return ResponseEntity.ok(new MessageResponse("Recompensa excluida com sucesso"));
    }
    @PostMapping(name = "/editarRecompensa")
    public ResponseEntity<?> editarRecompensa(@NotNull UserDTO userDTO, @NotNull RecompensaDTO recompensaDTO){
        userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDTO.getUsername()));

<<<<<<< HEAD:src/main/java/com/TCCProject/TCCPROJECT/Recompensa/RecompensaController.java
    @GetMapping("/listarCrianca")
=======
        Recompensa recompensaEditada = recompensaRepository.findById(recompensaDTO.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada recompensas"));

        recompensaEditada.setNomeRecompensa(recompensaDTO.getNomeRecompensa());
        recompensaEditada.setDescricaoRecompensa(recompensaDTO.getDescricaoRecompensa());
        recompensaEditada.setPontuacaoRecompensa(recompensaDTO.getPontuacaoRecompensa());

        for (Long criancaID: recompensaDTO.getCriancas()) {
            criancaRecompensaRepository.updateStatusByCriancaAndRecompensaId(CriancaRecompensa.getStatusRecompensa().toString(),
                    criancaID, recompensaEditada.getId());
        }

        recompensaRepository.save(recompensaEditada);

        return ResponseEntity.ok(new MessageResponse("Recompensa editada com sucesso"));
    }

    @PostMapping(name = "/resgatarRecompensa")
    public ResponseEntity<?> resgatarRecompensa(@NotNull UserDTO userDTO, @NotNull RecompensaDTO recompensaDTO){
        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDTO.getUsername()));

        Recompensa recompensaResgatada = recompensaRepository.findById(recompensaDTO.getId())
                .orElseThrow(() -> new RuntimeException("Nao foi possivel encontrar a recompensa"));

        criancaRecompensaRepository.updateStatusByCriancaAndRecompensaId(EStatusRecompensa.RESGATADA.toString(),recompensaResgatada.getId(),
                user.getId());

        user.setNewPontuacaoUser(recompensaResgatada);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("Parabens, aproveite sua recompensa, voce merece"));
    }
    @GetMapping(name = "/listarCrianca")
>>>>>>> ab968cc2c674c6b5eb8f94200d294f7766258897:src/main/java/com/TCCProject/TCCPROJECT/Controller/RecompensaController.java
    public ResponseEntity<List<Recompensa>> listarRecompensasCrianca(@NotNull UserDTO userDTO){
        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDTO.getUsername()));

        List<Long> listaRecompensasIDs = criancaRecompensaRepository.findByCriancaId(user.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada recompensas"));

        List<Recompensa> listaRecompensas = null;
        for (Long atividadeID: listaRecompensasIDs) {
            listaRecompensas.add(recompensaRepository.findById(atividadeID)
                    .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada recompensas")));
            }

        return ResponseEntity.ok(listaRecompensas);
    }

    @GetMapping("/listarAdulto")
    public ResponseEntity<List<Recompensa>> listarRecompensasAdulto(@NotNull UserDTO userDTO){
        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDTO.getUsername()));

        List<Recompensa> listaRecompensas = recompensaRepository.findByResponsavelId(user.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada recompensas"));

        return ResponseEntity.ok(listaRecompensas);
    }
}