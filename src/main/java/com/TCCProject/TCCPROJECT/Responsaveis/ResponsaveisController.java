package com.TCCProject.TCCPROJECT.Responsaveis;

import com.TCCProject.TCCPROJECT.DTO.UserDTO;
import com.TCCProject.TCCPROJECT.Entities.User;
import com.TCCProject.TCCPROJECT.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/responsabilidade")
public class ResponsaveisController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ResponsavelAndCriancaRepository responsavelAndCriancaRepository;

    @GetMapping("/listarCriancas")
    public ResponseEntity<List<User>> listarCriancas(@NotNull UserDTO userDTO){

        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado " + userDTO.getUsername()));

        List<Long> listaCriancaID = responsavelAndCriancaRepository.findByResponsavelId(user.getId())
                .orElseThrow(() -> new ArrayStoreException("Nao foram encontradas as criancas"));

        List<User> listaCriancas = new ArrayList<>();

        for (Long criancaID : listaCriancaID) {
                  listaCriancas.add(userRepository.findById(criancaID)
                          .orElseThrow(() -> new ArrayStoreException("Nao foi encontrada atividades")));
        }

        return ResponseEntity.ok(listaCriancas);
    }
}
