package domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    private String id;

    private String nome;

    private String email;

    @Column(name = "senha_hash")
    private String senhaHash;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;
}




