package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.PlayerCrudDAO;
import com.app.dao.dbutil.PostresqlConnection;
import com.app.exception.BusinessException;
import com.app.model.Player;

public class PlayerCrudDAOImpl implements PlayerCrudDAO {

	@Override
	public int createPlayer(Player player) throws BusinessException {
		int c = 0;
		try (Connection connection = PostresqlConnection.getConnection()) {
			String sql = "insert into roc_revature.player(id,name,age,gender,teamname,contact,dob) values(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, player.getId());
			preparedStatement.setString(2, player.getName());
			preparedStatement.setInt(3, player.getAge());
			preparedStatement.setString(4, player.getGender());
			preparedStatement.setString(5, player.getTeamname());
			preparedStatement.setLong(6, player.getContact());
			preparedStatement.setDate(7, new java.sql.Date(player.getDob().getTime())); // util.Date to sql.Date

			c = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take off this line when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return c;
	}

	@Override
	public void deletePlayer(int id) {
		// TODO Auto-generated method stub
		// Task
		String sql = "delete from roc_revature.player where id=?";
	}

	@Override
	public int updatePlayerContact(int id, long newContact) {
		// TODO Auto-generated method stub
		// Task
		String sql = "update roc_revature.player set contact=? where id=?";
		return 0;
	}

	@Override
	public Player getPlayerById(int id) throws BusinessException {
		Player player = null;
		try (Connection connection = PostresqlConnection.getConnection()) {
			String sql="select name,age,gender,teamname,contact,dob from roc_revature.player where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				player =new Player();
				player.setId(id);
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setGender(resultSet.getString("gender"));
				player.setContact(resultSet.getLong("contact"));
				player.setTeamname(resultSet.getString("teamname"));
				player.setDob(resultSet.getDate("dob"));
			}else {
				throw new BusinessException("No Player found with Id "+id);
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take off this line when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return player;
	}

	@Override
	public List<Player> getAllPlayers() throws BusinessException {
		List<Player> playersList=new ArrayList<>();
		try (Connection connection = PostresqlConnection.getConnection()) {
			String sql="select id,name,age,gender,teamname,contact,dob from roc_revature.player";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Player player =new Player();
				player.setId(resultSet.getInt("id"));
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setGender(resultSet.getString("gender"));
				player.setContact(resultSet.getLong("contact"));
				player.setTeamname(resultSet.getString("teamname"));
				player.setDob(resultSet.getDate("dob"));
				playersList.add(player);
			}
			if(playersList.size()==0)
			{
				throw new BusinessException("No Players in the DB so far");
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take off this line when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return playersList;
	}

}
