package ohtu.data_access;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

/**
 * Sisältää kaiken tiedostonkäsittelyyn liittyvän koodin. Anna FileUserDAO:lle
 * sen käyttämän tiedoston nimi konstruktorin parametrina.
 */
public class FileUserDao implements UserDao {

    private List<User> users;
    private String filename;

    public FileUserDao(String filename) {
        this.filename = filename;
        this.users = readFile();
    }

    private List<User> readFile() {
        List<User> allUsersListedInTheFile = new ArrayList<>();

        Scanner reader = null;

        try {
            reader = new Scanner(this.filename);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                User user = extractUser(line);
                allUsersListedInTheFile.add(user);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Can not read file. Error: " + e.getMessage());
        }

        return allUsersListedInTheFile;
    }

    private User extractUser(String line) {
        int space = line.indexOf(" ");
        String username = line.substring(0, space);
        String password = line.substring(space + 1);
        return new User(username, password);
    }

    @Override
    public List<User> listAll() {
        return this.users;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        users.add(user);

        FileWriter writer = null;

        try {
            writer = new FileWriter(this.filename, true);
            String userline = user.getUsername() + " " + user.getPassword();
            writer.write(userline + "\n");
            writer.close();

        } catch (IOException ex) {
            System.out.println("Can not write to file. Error: " + ex.getMessage());
        }

    }
}
