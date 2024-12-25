package ir.maktabsharif.user.service;

import ir.maktabsharif.user.dto.UserDTO;
import ir.maktabsharif.user.model.User;
import ir.maktabsharif.user.repository.UserRepository;
import ir.maktabsharif.user.repository.UserRepositoryImpl;

import javax.persistence.NoResultException;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void register(UserDTO userDTO) {
        User user = User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();
        userRepository.save(user);
    }

    @Override
    public Optional<UserDTO> login(String username, String password) {
        try {
        Optional<User> user = userRepository.findUserByUsernameAndPassword(username , password);
        UserDTO userDTO = UserDTO.builder()
                .username(user.get().getUsername())
                .password(user.get().getPassword())
                .build();
        return Optional.ofNullable(userDTO);
        } catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Boolean isUsernameExist(String username) {
        try {
        Optional<User> userByUsername = userRepository.findUserByUsername(username);
        return userByUsername.isPresent();
        } catch (NoResultException e) {
            return false;
        }
    }
}
