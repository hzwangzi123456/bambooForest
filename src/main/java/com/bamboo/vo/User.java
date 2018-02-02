package com.bamboo.vo;

/**
 * @author wangzi
 * @date 18/1/26 上午1:47.
 */
public class User implements Comparable<User> {

    private Integer id;

    private String password;

    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    /**
     * 比较方法(Arrays.sort排序:id升序)
     *
     * @param o 目标User
     * @return 0:相等,-1:小于目标User,1:大于目标User
     */
    @Override
    public int compareTo(User o) {
        if (this == o) {
            return 0;
        }
        if (this.toString().equals(o.toString())) {
            return 0;
        }
        if (this.id > o.getId()) {
            return 1;
        }
        return -1;
    }

}
