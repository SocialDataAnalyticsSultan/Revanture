package eg4;

import java.util.Objects;

public class Player implements Comparable {
	private int id;
	private String name;
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if(obj == null) 
			return false;
		if(getClass() != obj.getClass())
			return false;
		Player p2 = (Player) obj;
		return p2.id == this.id;
		
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(id);
		
	}

	@Override
	public int compareTo(Object obj) {
		Player p2 = (Player) obj;
		return (this.id> p2.id) ? 1 : ((this.id == p2.id) ? 0 : -1) ;
	}
	

}
