package agh.alleviation.model.user;

import agh.alleviation.util.UserType;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This class represents the admin of the application. This will be the user with the widest set of responsibilities.
 *
 * @author Anna Nosek
 * @see User
 */
@Entity
@Table(name = Admin.TABLE_NAME)
public class Admin extends User {
    /**
     * The constant TABLE_NAME.
     */
    public static final String TABLE_NAME = "admin";

    public Admin(){
        setUserType(UserType.ADMIN);
    }

    public Admin(final String name, final String login, final String email){
        super(name, login, email);
    }
}
