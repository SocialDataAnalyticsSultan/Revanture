package com.app.main;

import java.util.Date;
import java.util.List;

import com.app.dao.PlayerCrudDAO;
import com.app.dao.impl.PlayerCrudDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Player;

public class PlayerMain {

	public static void main(String[] args) {
		
		PlayerCrudDAO dao=new PlayerCrudDAOImpl();
		
//		Player p=new Player(108, "Eric", 24, 9001312321L, "Rockers", "M", new Date());
//		
//		try {
//			if(dao.createPlayer(p)!=0) {
//				System.out.println("Player created successfully");
//			}
//		} catch (BusinessException e) {
//			System.out.println(e.getMessage());
//		}
		
		try {
			Player player=dao.getPlayerById(108);
			if(player!=null) {
				System.out.println("Details of player with id "+player.getId());
				System.out.println(player);
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			List<Player> playerList=dao.getAllPlayers();
			if(playerList!=null && playerList.size()!=0) {
				System.out.println("\n\nFound "+playerList.size()+" no of players in DB.... Printing them all");
				for(Player p:playerList) {
					System.out.println(p);
				}
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		

	}

}

/* 1)Try runnning the same app and get idea of what is going on and where
 * 2)Look into the recording and parallely try to recreate  the whole app by yourself from scratch
 * 3)Complete update and delete operations and complete PlayerSearchDAOImpl
 * 
*/