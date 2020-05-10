package cn.scrmtest.modle;

public class LoginCase {
    private Integer id;
    private String title;
    private String username;
    private String password;
    private Integer expect;

    @Override
    public String toString() {
        return "LoginCase{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", expect=" + expect +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getExpect() {
        return expect;
    }

    public void setExpect(Integer expect) {
        this.expect = expect;
    }
}
