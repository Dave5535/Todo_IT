package dao;

import Model.AppUser;

import java.util.Collection;

public interface AppUserDAO extends BaseDao<AppUser> {


AppUser findById(int id);
     AppUser findByUsername(String username);

     void remove(String username);
}
