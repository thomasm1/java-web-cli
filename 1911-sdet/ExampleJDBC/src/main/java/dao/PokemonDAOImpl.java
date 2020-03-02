package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pokemon;
import util.JDBCConnection;

public class PokemonDAOImpl implements PokemonDAO {
	
	public static Connection conn = JDBCConnection.getConnection();

	public Pokemon getPokemon(int p_id) {
		
		try {
			String sql = "SELECT * FROM pokemon WHERE p_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(p_id));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Pokemon(
						rs.getInt("P_ID"),
						rs.getString("NAME"),
						rs.getString("BIO"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Pokemon getPokemon(String name) {
		
		try {
			String sql = "SELECT * FROM pokemon WHERE name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Pokemon(
						rs.getInt("P_ID"),
						rs.getString("NAME"),
						rs.getString("BIO"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Pokemon> getAllPokemon() {
		String sql = "SELECT * FROM pokemon";
		List<Pokemon> pokemon = new ArrayList<Pokemon>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pokemon.add(new Pokemon(
						rs.getInt("P_ID"),
						rs.getString("NAME"),
						rs.getString("BIO")));
			}
			
			return pokemon;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean addPokemon(Pokemon p) {
		
		String sql = "CALL add_new_pokemon(?,?)";
		
		try {
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, p.getName());
			cs.setString(2, p.getBio());
			
			cs.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean updatePokemon(Pokemon change) {
		String sql = "UPDATE pokemon SET name = ?, bio = ? WHERE p_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, change.getName());
			ps.setString(2, change.getBio());
			ps.setString(3, Integer.toString(change.getP_id()));
			
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean deletePokemon(int p_id) {
		String sql = "DELETE pokemon WHERE p_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(p_id));
			ps.executeQuery();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
