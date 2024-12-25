package ir.maktabsharif.user.service;

import ir.maktabsharif.user.dto.UserDTO;

import java.util.Optional;

public interface UserService {
    void register(UserDTO userDTO);
    Optional<UserDTO> login(String username , String password);
    Boolean isUsernameExist(String username);

}
