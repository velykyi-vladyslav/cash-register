package ua.lviv.velykyi.vladyslav.db.entity;

public class Employee extends Entity {
    //max 5
    private String login;
    //max 10
    private String pass;
    //max 20
    private String name;
    //max 20
    private String surname;
    private int roleId;
    private int localeId;

    public Employee() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getLocaleId() {
        return localeId;
    }

    public void setLocaleId(int localeId) {
        this.localeId = localeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", roleId=" + roleId +
                ", localeId=" + localeId +
                '}';
    }
}
