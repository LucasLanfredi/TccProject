package com.TCCProject.TCCPROJECT.Controller;

import com.TCCProject.TCCPROJECT.Config.MessageResponse;
import com.TCCProject.TCCPROJECT.DTO.AtividadeDTO;
import com.TCCProject.TCCPROJECT.DTO.UserDTO;
import com.TCCProject.TCCPROJECT.Entities.Atividade;
import com.TCCProject.TCCPROJECT.Entities.CriancaAtividade;
import com.TCCProject.TCCPROJECT.Entities.User;
import com.TCCProject.TCCPROJECT.Repositories.AtividadeRepository;
import com.TCCProject.TCCPROJECT.Repositories.CriancaAtividadeRepository;
import com.TCCProject.TCCPROJECT.Repositories.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.TCCProject.TCCPROJECT.Models.EStatusAtividade.ATIVA;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    AtividadeRepository atividadesRepository;
    
    @Autowired
    CriancaAtividadeRepository criancaAtividadeRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping(name = "/criarAtividade")
    public ResponseEntity<?> criarAtividade (@NotNull UserDTO userDTO, @NotNull AtividadeDTO atividadeDTO){
        User adulto = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario Responsavel nao Encontrado " + userDTO.getUsername()));

        Atividade atividade = new Atividade(atividadeDTO.getNomeAtividade(),
                atividadeDTO.getDescricaoAtividade(),
                atividadeDTO.getDataAtividade(),
                atividadeDTO.getValorPontos(),
                atividadeDTO.isNecessarioValidar(),
                adulto.getId(),
                ATIVA);
        Long atividadeID = atividadesRepository.save(atividade).getId();

        for(Long criancaID : atividadeDTO.getCriancas()){
            User Crianca = userRepository.findById(criancaID)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario nao Encontrado. ID: " + criancaID));
            criancaAtividadeRepository.save(new CriancaAtividade(Crianca.getId(), atividadeID));
        }
        return ResponseEntity.ok(new MessageResponse("Atividade cadastrada com sucesso"));
    }

    @PostMapping(name = "/deletarAtividade")
    public ResponseEntity<?> deletarAtividade (@NotNull UserDTO userDTO, @NotNull AtividadeDTO atividadeDTO){
        User adulto = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario Responsavel nao Encontrado: " + userDTO.getUsername()));

        Atividade atividadeExcluida = atividadesRepository.findById(atividadeDTO.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada a atividade: " + atividadeDTO.getNomeAtividade()));

        atividadesRepository.deleteById(atividadeDTO.getId());
        List<Long> listaDeAtividades = criancaAtividadeRepository.findRelacionamentoWithAtividadeID(atividadeExcluida.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada a atividade: " + atividadeDTO.getNomeAtividade()));;

        for(Long atividadeID : listaDeAtividades){
            criancaAtividadeRepository.deleteById(atividadeID);
        }

        return ResponseEntity.ok(new MessageResponse("Atividade excluida com sucesso"));
    }

    @GetMapping(name = "/listarCrianca")
    public ResponseEntity<List<Atividade>> listarAtividadesCrianca(@NotNull UserDTO userDTO){
        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDTO.getUsername()));

        List<Long> listaAtividadesIDs = criancaAtividadeRepository.findAtividadeIDByCriancaID(user.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada atividades"));

        List<Atividade> listaAtividades = null;
        for (Long atividadeID: listaAtividadesIDs) {
            listaAtividades.add(atividadesRepository.findById(atividadeID)
                    .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada atividades"))); 
            }

        return ResponseEntity.ok(listaAtividades);
    }

    @GetMapping(name = "/listarAdulto")
    public ResponseEntity<List<Atividade>> listarAtividadesAdulto(@NotNull UserDTO userDTO){
        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDTO.getUsername()));

        List<Atividade> listaAtividades = atividadesRepository.findByAdultoID(user.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada atividades"));

        return ResponseEntity.ok(listaAtividades);
    }
}
