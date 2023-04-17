package demo.ToeicWord.user.repository;

import demo.ToeicWord.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findbyId(Long id);

    List<User> selectALlUsers();

    Optional<User> updateById(User user);

    int deleteById(Long id);
}
