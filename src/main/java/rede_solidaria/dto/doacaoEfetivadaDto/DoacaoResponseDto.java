package rede_solidaria.dto.doacaoEfetivadaDto;

import java.time.LocalDateTime;

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
public class DoacaoResponseDto {
    private Integer id;
    @Size(max = 255)
    private String obs;
    private LocalDateTime dataEfetivacao;
}
