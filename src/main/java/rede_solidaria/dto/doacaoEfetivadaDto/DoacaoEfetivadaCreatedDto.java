package rede_solidaria.dto.doacaoEfetivadaDto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DoacaoEfetivadaCreatedDto {
    @Size(max = 255)
    private String obs;
}
