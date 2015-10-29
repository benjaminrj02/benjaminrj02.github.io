package model.datastore.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BaseballStats;
import model.IBaseballStatsDAO;

/**
 * @author Richard Benjamin
 * @version 20151015
 *
 */
public class BaseballStatsDAO implements IBaseballStatsDAO {
	
	protected final static boolean DEBUG = true;

	@Override
	public void createRecord(BaseballStats baseballstats) {
		final String QUERY = "insert into baseballstats (playerId, lastName, firstName, singles, doubles, triples, homeruns ) VALUES (null, ?, ?, ?, ?,?,?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(QUERY);) {
			stmt.setString(1, baseballstats.getLastName());
			stmt.setString(2, baseballstats.getFirstName());
			stmt.setString(3, baseballstats.getSingles());
			stmt.setString(4, baseballstats.getDoubles());
			stmt.setString(5, baseballstats.getTriples());
			stmt.setString(6, baseballstats.getHomeruns());
			if(DEBUG) System.out.println(stmt.toString());
			stmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("createRecord SQLException: " + ex.getMessage());
		}
	}

	@Override
	public BaseballStats retrieveRecordById(int playerId) {
		final String QUERY = "select playerId, lastName, firstName, Singles, Doubles, Triples, Homeruns from baseballstats";
		// final String QUERY = "select playerId, lastName, firstName, singles,doubles,triples,homeruns
		// salary from baseballstats where playerId = ?";
		BaseballStats emp = null;

		try (Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(QUERY)) {
			// stmt.setInt(1, id);
			if(DEBUG) System.out.println(stmt.toString());
			ResultSet rs = stmt.executeQuery(QUERY);

			if (rs.next()) {
				emp = new BaseballStats(rs.getInt("playerId"), rs.getString("lastName"), rs.getString("firstName"),
						rs.getString("Singles"), rs.getString("Doubles"),rs.getString("Triples"),rs.getString("Homeruns"));
			}
		} catch (SQLException ex) {
			System.out.println("retrieveRecordById SQLException: " + ex.getMessage());
		}

		return emp;
	}

	@Override
	public List<BaseballStats> retrieveAllRecords() {
		final List<BaseballStats> myList = new ArrayList<>();
		final String QUERY = "select playerId, lastName, firstName, singles, doubles, triples, homeruns from baseballstats";

		try (Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(QUERY)) {
			if(DEBUG) System.out.println(stmt.toString());
			ResultSet rs = stmt.executeQuery(QUERY);
			
			while (rs.next()) {
				myList.add(new BaseballStats(rs.getInt("playerId"), rs.getString("lastName"), rs.getString("firstName"),
						rs.getString("Singles"), rs.getString("Doubles"),rs.getString("Triples"),rs.getString("Homeruns")));
			}
		} catch (SQLException ex) {
			System.out.println("retrieveAllRecords SQLException: " + ex.getMessage());
		}

		return myList;
	}

	@Override
	public void updateRecord(BaseballStats updatedbaseballstats) {
		final String QUERY = "update baseballstats set lastName=?, firstName=?, singles=?, doubles=?, triples=?, homeruns=?, where playerId=?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(QUERY)) {
			stmt.setString(1, updatedbaseballstats.getLastName());
			stmt.setString(2, updatedbaseballstats.getFirstName());
			stmt.setString(3, updatedbaseballstats.getSingles());
			stmt.setString(4, updatedbaseballstats.getDoubles());
			stmt.setString(5, updatedbaseballstats.getTriples());
			stmt.setString(6, updatedbaseballstats.getHomeruns());
			stmt.setInt(5, updatedbaseballstats.getPlayerId());
			if(DEBUG) System.out.println(stmt.toString());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("updateRecord SQLException: " + ex.getMessage());
		}
	}

	@Override
	public void deleteRecord(int playerId) {
		final String QUERY = "delete from baseballstats where playerId = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(QUERY)) {
			stmt.setInt(1, playerId);
			if(DEBUG) System.out.println(stmt.toString());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("deleteRecord SQLException: " + ex.getMessage());
		}
	}
	
	@Override
	public void getMostHomeRuns() {
		final String QUERY = "MAX(Homeruns = ?)";
		
		try (Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(QUERY)) {
			stmt.get("MAX", Homeruns);
			if(DEBUG) System.out.println(stmt.toString());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("deleteRecord SQLException: " + ex.getMessage());
		}
	}
	@Override
	public void deleteAllRecords() {
		System.out.println("Sike! Delete it one at a time");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (BaseballStats baseballstats : retrieveAllRecords()) {
			sb.append(baseballstats.toString() + "\n");
		}

		return sb.toString();
	}

	@Override
	public void deleteRecord(BaseballStats baseballstats) {
		// TODO Auto-generated method stub
		
	}
}
