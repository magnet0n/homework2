package tr.com.mis49m.hw2base;

import java.io.Serializable;

/**
 * Created by antonio on 11/1/2017.
 */

public class content implements Serializable
{
    private String username;
    private String mmes;
    private String countComment = "0";
    private String countLike = "0";

    public content(String username, String message) {
        this.username = username;
        this.mmes = message;
    }

    public String getCountComment() {
        return countComment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCountLike() {
        return countLike;
    }

    public void setCountLike(String countLike) {
        this.countLike = countLike;
    }

    public String getMmes() {
        return mmes;
    }

    public void setMmes(String mmes) {
        this.mmes = mmes;
    }
}

