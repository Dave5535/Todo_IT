package InterFace;

import Model.AppUser;
import SequencersPack.PersonIdSequencer;
import org.example.Person;

import java.util.*;

public class AppUserDAOCollection implements AppUserDAO {
    private List<AppUser> users;

    public AppUserDAOCollection() {
        users = new ArrayList<>();
    }
    @Override
    public AppUser persist(AppUser appUser) {
if (appUser == null) throw new IllegalArgumentException("appUser was null");
     appUser.setId(PersonIdSequencer.nextId());
        users.add(appUser);
        return appUser;
    }
    @Override
    public AppUser findByUsername(String userInput) {
        if (userInput == null) throw new IllegalArgumentException("ssn was null");
        for (AppUser person : users)
            if (person.getUserName().equalsIgnoreCase(userInput)) return person;
        return null;
    }
    @Override
    public Collection<AppUser> findAll() {
        for (AppUser appUser : users)
            System.out.println(appUser);
        return users;
    }
    @Override
    public void remove(String username) {
        users.removeIf(removeItem -> removeItem.getUserName().equals(username));
    }
}
