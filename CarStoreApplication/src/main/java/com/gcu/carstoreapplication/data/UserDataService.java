package com.gcu.carstoreapplication.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.carstoreapplication.model.DataAccessInterface;
import com.gcu.carstoreapplication.model.ProductModel;
import com.gcu.carstoreapplication.model.UserModel;

/**
 * Service class that provides data access for {@link UserModel} using JDBC and Spring's {@link JdbcTemplate}.
 */
@Service
public class UserDataService implements DataAccessInterface<UserModel>{

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * Constructor that initializes the data source and sets up the {@link JdbcTemplate}.
	 *
	 * @param dataSource the {@link DataSource} to be used for database connections
	 */
	public UserDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/**
	 * Retrieves all users from the database.
	 *
	 * @return a list of all {@link UserModel} records
	 */
	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";
		List<UserModel> users = new ArrayList<UserModel>();
		try {
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while (srs.next()) {
				users.add(new UserModel(srs.getInt("id"), srs.getString("userName"), srs.getString("firstName"),
						srs.getString("lastName"), srs.getString("password"), srs.getString("email"), srs.getString("phone")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * Placeholder for retrieving a user by ID.
	 *
	 * @param id the ID of the user to retrieve
	 * @return always returns {@code null} as this is not yet implemented
	 */
	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Inserts a new user into the database.
	 *
	 * @param user the {@link UserModel} to create
	 * @return true if insertion was successful, false otherwise
	 */
	@Override
	public boolean create(UserModel user) {
		String sql = "INSERT INTO users(userName, firstName, lastName, password, email, phone) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			int rows = jdbcTemplateObject.update(sql,
					user.getUsername(),
					user.getFirstName(),
					user.getLastName(),
					user.getPassword(),
					user.getEmail(),
					user.getPhone());
			return rows == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Placeholder for updating a user.
	 *
	 * @param t the {@link UserModel} to update
	 * @return always returns {@code false} as this is not yet implemented
	 */
	@Override
	public boolean update(UserModel t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Placeholder for deleting a user.
	 *
	 * @param t the {@link UserModel} to delete
	 * @return always returns {@code false} as this is not yet implemented
	 */
	@Override
	public boolean delete(UserModel t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Retrieves a user from the database by their username.
	 *
	 * @param userName the username to search for
	 * @return a {@link UserModel} if found, or {@code null} if not found
	 */
	public UserModel getByUserName(String userName) {
		String sql = "SELECT * FROM users WHERE users.userName = ?";
		List<UserModel> users = new ArrayList<>();

		try {
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, userName);
			while (srs.next()) {
				users.add(new UserModel(
						srs.getInt("id"),
						srs.getString("userName"),
						srs.getString("firstName"),
						srs.getString("lastName"),
						srs.getString("password"),
						srs.getString("email"),
						srs.getString("phone")
				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users.isEmpty() ? null : users.get(0); // Safely return the first user or null
	}

}
