package com.TCCProject.TCCPROJECT.DTO;

import com.TCCProject.TCCPROJECT.Entities.Role;
import com.TCCProject.TCCPROJECT.Models.EUserType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private Date dataNascimento;

    private String descricao;
}
