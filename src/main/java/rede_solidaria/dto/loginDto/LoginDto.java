package rede_solidaria.dto.loginDto;

import jakarta.validation.constraints.NotBlank;
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
public class LoginDto {
    @NotBlank(message = "O email é obrigatório")
    private String email;
    @NotBlank(message = "A senha é obrigatória")
    private String senha;
}
