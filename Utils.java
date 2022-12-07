import java.util.ArrayList;

public class Utils {
    public int getUserAccountIndex(ArrayList<User> users, String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(name))
                return i;
        }
        return -1;
    }

    public int getProjectIndex(String id, ArrayList<Project> projects) {
        int count = 0;
        for (Project item : projects) {
            if (item.getId() == id) {
                break;
            } else
                ++count;
        }
        return count - 1;
    }

    public int getUserIndex(ArrayList<User> users, String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    public int getActivityIndex(String id, ArrayList<Activity> activities) {
        int count = 0;
        for (Activity item : activities) {
            if (item.getId() == id) {
                break;
            } else
                ++count;
        }
        return count - 1;
    }

    public int getTaskIndex(String name, ArrayList<Task> tasks) {
        int count = 0;
        for (Task item : tasks) {
            if (item.getName() == name) {
                break;
            } else
                ++count;
        }
        return count - 1;
    }
}
