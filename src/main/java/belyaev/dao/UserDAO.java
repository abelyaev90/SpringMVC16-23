package belyaev.dao;

import belyaev.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO  {
    private static int USERS_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++USERS_COUNT, "Nick"));
        users.add(new User(++USERS_COUNT, "Roland"));
        users.add(new User(++USERS_COUNT, "Mia"));
        users.add(new User(++USERS_COUNT, "Jone"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user->user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USERS_COUNT);
        users.add(user);
    }

    public void update(int id, User updateUser) {
        User userToBeUpdate = show(id);
        userToBeUpdate.setName(updateUser.getName());
    }

    public void delete(int id) {
        users.removeIf(p -> p.getId() == id);
    }
}
