package rede_solidaria.database.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter 
// @AllArgsConstructor
// @NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "administrador")
public class Administrador extends Usuario {
    
}
