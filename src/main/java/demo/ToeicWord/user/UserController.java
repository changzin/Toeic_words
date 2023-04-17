package demo.ToeicWord.user;

import demo.ToeicWord.user.domain.User;
import demo.ToeicWord.user.service.UserService;
import demo.ToeicWord.user.userDto.UserSignUp;
import demo.ToeicWord.user.userDto.UserUpdate;
import demo.ToeicWord.word.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("users/new")
    public ResponseEntity create(UserSignUp userSignUp){
        User user = new User(userSignUp.getUserName(), userSignUp.getPassword(), 0);
        try {
            user = userService.addOne(user);
        }
        catch (IllegalStateException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/users")
    public ResponseEntity readOne(@RequestParam("id") Long id){
        try{
            userService.findOne(id);
        }
        catch (IllegalStateException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
        return ResponseEntity.ok().body(userService.findOne(id));
    }

    @GetMapping("/users/findAll")
    public ResponseEntity readAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping("users/update")
    public ResponseEntity updateOne(UserUpdate userUpdate){
        System.out.println("userUpdate.getUserId() = " + userUpdate.getUserId());
        System.out.println("userUpdate.getUserId() = " + userUpdate.getUserName());
        System.out.println("userUpdate.getUserId() = " + userUpdate.getPassword());
        try {
            userService.updateOne(new User(userUpdate.getUserId(), userUpdate.getUserName(), userUpdate.getPassword()));
        }
        catch (IllegalStateException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
        return ResponseEntity.ok().body(userService.findOne(userUpdate.getUserId()));
    }

    @PostMapping("users/delete")
    public String removeOne(Long id){
        return userService.deleteOne(id);
    }
}
