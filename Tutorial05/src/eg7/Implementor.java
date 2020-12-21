package eg7;

public class Implementor implements Child {

	@Override
	public void parent1() {
		System.out.println("parent1()");
		
	}

	@Override
	public void parent2() {
		System.out.println("parent2()");
		
	}

	@Override
	public void parent3() {
		System.out.println("parent3()");
		
	}

	@Override
	public void child1() {
		System.out.println("child1()");
		
	}

	@Override
	public void child2() {
		System.out.println("child2()");
		
	}

	@Override
	public void child3() {
		System.out.println("child3()");
		
	}

}
