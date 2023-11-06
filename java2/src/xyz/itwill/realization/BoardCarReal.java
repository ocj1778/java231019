package xyz.itwill.realization;

public class BoardCarReal implements BoatCar {
	@Override
	public void run() {
		System.out.println("땅위를 달리는 능력");
	}

	@Override
	public void navigate() {
		System.out.println("물위를 향해는 능력");
	}

	@Override
	public void floating() {
		System.out.println("공중에 떠오르는 능력");
	}
}
