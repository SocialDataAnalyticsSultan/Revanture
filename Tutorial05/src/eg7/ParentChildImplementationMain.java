package eg7;

public class ParentChildImplementationMain {

	public static void main(String[] args) {
		
		System.out.println("Accesing using Parent");
		Parent p = new Implementor();
		p.parent1();
		p.parent2();
		p.parent3();
		
		System.out.println("Accesing using Child");
		Child c = new Implementor();
		c.child1();
		c.child2();
		c.child3();

	}

}
