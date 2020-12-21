package eg4;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PlayerMain {

	public static void main(String[] args) {
		
		Player player1 = new Player(100, "Sachin");
		Player player2 = new Player(100, "Sourav");
		
		if(player1.equals(player2)) {
			System.out.println("Both players are same");
		}else {
			System.out.println("Players are not same");
		}
		
		Set<Player> players = new TreeSet <Player>();
		players.add(new Player(100, "Dinesh"));  
		players.add(new Player(100, "Dinesh"));
		players.add(new Player(100, "Dinesh"));
		players.add(new Player(100, "Dinesh"));
		players.add(new Player(100, "Dinesh"));
		players.add(new Player(105, "Dinesh"));
		players.add(new Player(99, "Dinesh"));
		
		
		System.out.println("Printing Players");
		for (Player p: players) {
			System.out.println(p);
		}

	}

}
