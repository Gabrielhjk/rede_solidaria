package rede_solidaria.database.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter 
@Setter
// @AllArgsConstructor
// @NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
public class Doador extends Usuario{
    
}
