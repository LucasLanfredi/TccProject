package com.TCCProject.TCCPROJECT.Entities;

import com.TCCProject.TCCPROJECT.Models.EUserType;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @NotBlank
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @NotBlank
    @Column(name = "pontuacao_user")
    private int pontuacaoUser;

    @Size(max = 120)
    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @JoinTable(	name = "user_type",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_type_id"))
    private EUserType EUserType;

    public User() {
        super();
    }

    public User(String firstName, String lastName, int pontuacaoUser, String username, String password, Date dataNascimento,
                EUserType EUserType) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.pontuacaoUser = pontuacaoUser;
        this.username = username;
        this.password = password;
        this.dataNascimento = dataNascimento;
        this.EUserType = EUserType;
    }

    public User(String firstName, String lastName, int pontuacaoUser, String username, String email, String password,
                Date dataNascimento, EUserType EUserType) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.pontuacaoUser = pontuacaoUser;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dataNascimento = dataNascimento;
        this.EUserType = EUserType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public EUserType getEUserType() {
        return EUserType;
    }

    public void setEUserType(EUserType EUserType) {
        this.EUserType = EUserType;
    }

    public int getPontuacaoUser() {
        return pontuacaoUser;
    }

    public void setPontuacaoUser(int pontuacaoUser) {
        this.pontuacaoUser = pontuacaoUser;
    }

    public void setNewPontuacaoUser(Atividade atividadePontuacao) {
        this.pontuacaoUser = this.pontuacaoUser + atividadePontuacao.getValorPontos();
    }

    public void setNewPontuacaoUser(Recompensa recompensaCusto) {
        this.pontuacaoUser = this.pontuacaoUser - recompensaCusto.getPontuacaoRecompensa();
    }
}