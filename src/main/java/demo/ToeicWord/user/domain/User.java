package demo.ToeicWord.user.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long userId;
    private String userName;
    private String password;
    private int tier;
    private int token;

    public User(Long userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.tier = 0;
    }

    public User(String userName, String password, int tier) {
        this.userName = userName;
        this.password = password;
        this.tier = tier;
    }

    public User(Long userId, String userName, String password, int tier) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.tier = tier;
    }


}
