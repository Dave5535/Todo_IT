package Model;

public class AppUser {
    private String userName;
    private String password;
    private AppRole role;
//constructor

    public AppUser(String userName,String password,AppRole role){
        setUserName(userName);
        setPassword(password);
        setRole(role);
    }
  //methods

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "User name : "+ userName;
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
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        if (password == null) throw new IllegalArgumentException("Role can't be null.");
        this.role = role;
    }
}
