package com.TCCProject.TCCPROJECT.Atividade;

import com.TCCProject.TCCPROJECT.Config.MessageResponse;
import com.TCCProject.TCCPROJECT.DTO.AtividadeDTO;
import com.TCCProject.TCCPROJECT.DTO.UserDTO;
import com.TCCProject.TCCPROJECT.Entities.Atividade;
import com.TCCProject.TCCPROJECT.Entities.CriancaAtividade;
import com.TCCProject.TCCPROJECT.Entities.User;
import com.TCCProject.TCCPROJECT.Models.EStatusAtividade;
import com.TCCProject.TCCPROJECT.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import java.util.ArrayList;
import java.util.HashSet;
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

    @PostMapping("/criarAtividade")
    public ResponseEntity<?> criarAtividade (@Valid @RequestBody AtividadeDTO atividadeDTO){
        User adulto = userRepository.findById(atividadeDTO.getResponsavelId())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado, ID : " + atividadeDTO.getResponsavelId()));

        Atividade atividade = new Atividade(atividadeDTO.getNomeAtividade(),
                atividadeDTO.getDescricaoAtividade(),
                atividadeDTO.getDataAtividade(),
                atividadeDTO.getValorPontos(),
                false,
                adulto.getId());
        Atividade atividadeNew = atividadesRepository.save(atividade);

        for(Long criancaID : atividadeDTO.getCriancas()){
            User Crianca = userRepository.findById(criancaID)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario nao Encontrado. ID: " + criancaID));
            criancaAtividadeRepository.save(new CriancaAtividade(Crianca.getId(), atividadeNew.getId(), ATIVA));
        }
        return ResponseEntity.ok(new MessageResponse("Atividade cadastrada com sucesso"));
    }

    @PostMapping("/deletarAtividade")
    public ResponseEntity<?> deletarAtividade (@NotNull AtividadeDTO atividadeDTO){
        userRepository.findById(atividadeDTO.getResponsavelId())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario Responsavel nao Encontrado, ID: " + atividadeDTO.getResponsavelId()));

        Atividade atividadeExcluida = atividadesRepository.findById(atividadeDTO.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada a atividade: " + atividadeDTO.getNomeAtividade()));

        List<Long> listaDeAtividades = criancaAtividadeRepository.findByAtividadeId(atividadeExcluida.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada a atividade: " + atividadeDTO.getNomeAtividade()));

        for(Long criancaAtividadeID : listaDeAtividades){
            criancaAtividadeRepository.deleteById(criancaAtividadeID);
        }

        atividadesRepository.deleteById(atividadeDTO.getId());

        return ResponseEntity.ok(new MessageResponse("Atividade excluida com sucesso"));
    }

    @PostMapping("/editaratividade")
    public ResponseEntity<?> editarAtividade(@NotNull AtividadeDTO atividadeDTO){
        userRepository.findById(atividadeDTO.getResponsavelId())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado, ID : " + atividadeDTO.getResponsavelId()));

        Atividade atividadeEditada = atividadesRepository.findById(atividadeDTO.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada atividades"));

        atividadeEditada.setNomeAtividade(atividadeDTO.getNomeAtividade());
        atividadeEditada.setDescricaoAtividade(atividadeDTO.getDescricaoAtividade());
        atividadeEditada.setDataAtividade(atividadeDTO.getDataAtividade());
        atividadeEditada.setNecessarioValidar(false);
        atividadeEditada.setValorPontos(atividadeDTO.getValorPontos());

        for (Long criancaID: atividadeDTO.getCriancas()) {
            criancaAtividadeRepository.updateStatusByCriancaAndAtividadeId(atividadeDTO.getStatusAtividade().toString(),
                    criancaID, atividadeEditada.getId());
        }

        atividadesRepository.save(atividadeEditada);

        return ResponseEntity.ok(new MessageResponse("Atividade editada com sucesso"));
    }

    @GetMapping("/listarCrianca")
    public ResponseEntity<List<Atividade>> listarAtividadesCrianca(@NotNull UserDTO userDTO){
        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDTO.getUsername()));

        List<Long> listaAtividadesIDs = criancaAtividadeRepository.findByCriancaId(user.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada atividades"));

        List<Atividade> listaAtividades = new ArrayList<>();

        for (Long atividadeID: listaAtividadesIDs) {
            listaAtividades.add(atividadesRepository.findById(atividadeID)
                    .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada atividades"))); 
            }

        return ResponseEntity.ok(listaAtividades);
    }

    @GetMapping("/listarAdulto")
    public ResponseEntity<List<Atividade>> listarAtividadesAdulto(@NotNull UserDTO userDTO){
        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDTO.getUsername()));

        List<Atividade> listaAtividadesAdulto = atividadesRepository.findByResponsavelId(user.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada atividades"));

        return ResponseEntity.ok(listaAtividadesAdulto);
    }

    @PostMapping("/realizarAtividade")
    public ResponseEntity<?> realizarAtividade(@NotNull UserDTO userDTO, @NotNull AtividadeDTO atividadeDTO){
        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDTO.getUsername()));

        Atividade atividadeRealizada = atividadesRepository.findById(atividadeDTO.getId())
                .orElseThrow(() -> new RuntimeException("Nao foi possivel encontrar a atividade"));

        criancaAtividadeRepository.updateStatusByCriancaAndAtividadeId(EStatusAtividade.REALIZADA.toString(),atividadeRealizada.getId(),
                    user.getId());

        user.setNewPontuacaoUser(atividadeRealizada);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("Parabens, tarefa foi concluida"));
    }
}
