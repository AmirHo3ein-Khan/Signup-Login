package ir.maktabsharif.user.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class UserDTO {
    @NotBlank(message = "username required!")
    @Size(min = 8 , message = "username must have at least 8 character!")
    private String username;
    @NotBlank(message = "password required!")
    private String password;
}
