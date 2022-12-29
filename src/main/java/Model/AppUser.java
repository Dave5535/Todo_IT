package Model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AppUser {
    private Integer id;
    private String userName;
    private String password;
    private Set<AppRole> roles;


//constructor

    public AppUser(String userName,String password){
        setUserName(userName);
        setPassword(password);
        addRole(AppRole.ROLE_APP_USER);
    }

    public AppUser(String username, String password, AppRole role) {
        setUserName(username);
        setPassword(password);
        addRole(role);
    }
    public AppUser(Integer id,String username, String password, AppRole role) {

       this.id = id;
       setUserName(username);
       setPassword(password);
        addRole(role);
    }


    //methods
  public void addRole(AppRole role) {
      if (role == null) throw new IllegalArgumentException("Role was null");
      if (roles == null) roles = new HashSet<>();
      roles.add(AppRole.ROLE_APP_USER);
  }
    public void removeRole(AppRole role) {
        if (role == null) throw new IllegalArgumentException("Role was null");
        if (roles != null) roles.remove(role);
    }
    @Override
    public int hashCode() {
        return Objects.hash(userName,roles);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(userName, appUser.userName) && Objects.equals(roles, appUser.roles);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + userName + '\'' +
                ", roles=" + roles +
                '}';
    }


//setters & getters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName == null) throw new IllegalArgumentException("Username can't be null.");
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) throw new IllegalArgumentException("Password can't be null.");
        if (password.length() < 8  ) throw new IllegalArgumentException("Password must be at least 8 characters long");
        this.password = password;
    }

    public Set<AppRole> getRole() {
        return roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRole(Set<AppRole> role) {
        if (password == null) throw new IllegalArgumentException("Role can't be null.");
        this.roles = role;


    }



}
