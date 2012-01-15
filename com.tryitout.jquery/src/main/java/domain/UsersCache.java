package domain;

import java.util.ArrayList;
import java.util.List;

public class UsersCache {

	private List<User> users = new ArrayList<User>();

	{
		users.add(new User("test1", "test1surneme"));
		users.add(new User("test2", "test1surneme2"));
		users.add(new User("test3", "test1surneme3"));
		users.add(new User("test4", "test1surneme4"));

	}
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
