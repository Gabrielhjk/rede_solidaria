package rede_solidaria.dto.doacaoEfetivadaDto;

import java.time.LocalDateTime;

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
    private String obs;
    private LocalDateTime dataEfetivacao;
}
