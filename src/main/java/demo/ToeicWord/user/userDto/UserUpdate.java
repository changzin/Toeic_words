package demo.ToeicWord.user.userDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdate {
    private Long userId;
    private String userName;
    private String password;
}
