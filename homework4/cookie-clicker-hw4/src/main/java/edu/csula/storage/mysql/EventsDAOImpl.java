package edu.csula.storage.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.csula.models.Guestbook;
import edu.csula.storage.EventsDAO;
import edu.csula.storage.Database;
import edu.csula.models.Event;

import javax.xml.transform.Result;

public class EventsDAOImpl implements EventsDAO {
	private final Database context;

	// TODO: fill the Strings with the SQL queries as "prepated statements" and
	//       use these queries variable accordingly in the method below
	protected static final String getAllQuery = "Select * From events;";
	protected static final String getByIdQuery = "Select * From events Where id = ?;";
	protected static final String setQuery = "Update events Set ? Where id = ?;";
	protected static final String addQuery = "Insert into events values (?,?,?);";
	protected static final String removeQuery = "Delete from events Where id = ?;";

	public EventsDAOImpl(Database context) {
		this.context = context;
	}

	@Override
	public List<Event> getAll() {
		// TODO: get all events from jdbc
		List<Event> result = new ArrayList<>();
		try (Connection c = context.getConnection(); Statement stmt = c.createStatement()) {
			ResultSet set = stmt.executeQuery(EventsDAOImpl.getAllQuery);
			while (set.next()) {
				Event entry = new Event(set.getInt("id"), set.getString("name"), set.getString("description"), set.getInt("trigger_at"));
				result.add(entry);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		return result;
	}

	@Override
	public Optional<Event> getById(int id) {
		// TODO: get specific event by id
		try(Connection c = context.getConnection(); PreparedStatement stmt = c.prepareStatement(EventsDAOImpl.getByIdQuery)){
			stmt.setInt(1, id);
			ResultSet set = stmt.executeQuery();
			while(set.next()){
				if(set.getInt(1) == id){
					String name = set.getString(2);
					String description = set.getString(3);
					int triggerAt = set.getInt(4);
					return Optional.of(new Event(id, name, description, triggerAt));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public void set(int id, Event event) {
		// TODO: update specific event by id
		try (Connection c = context.getConnection(); PreparedStatement stmt = c.prepareStatement(EventsDAOImpl.setQuery)) {
			stmt.setString(1, event.getName());
			stmt.setString(2, event.getDescription());
			stmt.setInt(3, event.getTriggerAt());
			stmt.setInt(4, event.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(Event event) {
		// TODO: implement jdbc logic to add a new event
		try (Connection c = context.getConnection(); PreparedStatement stmt = c.prepareStatement(EventsDAOImpl.addQuery)) {
			stmt.setString(1, event.getName());
			stmt.setString(2, event.getDescription());
			stmt.setInt(3, event.getTriggerAt());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		// TODO: implement jdbc logic to remove event by id
		try (Connection c = context.getConnection(); PreparedStatement stmt = c.prepareStatement(EventsDAOImpl.removeQuery)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
