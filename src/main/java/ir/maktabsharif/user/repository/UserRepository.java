package ir.maktabsharif.user.repository;

import ir.maktabsharif.user.model.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findUserByUsernameAndPassword(String username , String password);
    Optional<User> findUserByUsername(String username);
}
