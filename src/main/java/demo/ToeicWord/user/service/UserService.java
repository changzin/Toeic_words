package demo.ToeicWord.user.service;

import demo.ToeicWord.user.domain.User;
import demo.ToeicWord.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addOne(User user){
        List<User> userList = findAll();
        if (userList != null){
            for(User u : userList){
                if (u.getUserName().equals(user.getUserName())){
                    throw new IllegalStateException("이미 존재하는 사용자입니다");
                }
            }
        }
        return userRepository.save(user);
    }

    public User findOne(Long id){
        if (userRepository.findbyId(id).isEmpty())
            throw new IllegalStateException("존재하지 않는 사용자입니다");
        return userRepository.findbyId(id).get();
    }

    public List<User> findAll(){
        return userRepository.selectALlUsers();
    }

    public User updateOne(User user){
        if (userRepository.updateById(user).isEmpty())
            throw new IllegalStateException("존재하지 않는 사용자입니다");
        return userRepository.findbyId(user.getUserId()).get();
    }

    public String deleteOne(Long id){
        int result = userRepository.deleteById(id);
        if (result == 0){
            return "존재하지 않는 사용자입니다";
        }
        else{
            return "삭제 완료";
        }
    }
}
