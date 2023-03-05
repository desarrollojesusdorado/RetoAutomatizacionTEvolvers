package model.restful;

import lombok.Getter;

@Getter
public class DataGetToken {

    public String username;
    public String password;

    public DataGetToken withUsername(String username) {
        this.username = username;
        return this;
    }

    public DataGetToken withPassword(String password) {
        this.password = password;
        return this;
    }

}
