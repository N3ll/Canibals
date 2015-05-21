public class Canibals {

	public static void main(String[] args) {
		Person victim1 = new Person("Bon");
		Person victim2 = new Person("Sam");
		Person victim3 = new Person("Bob");
		Person victim4 = new Person("An");
		Person victim5 = new Person("Lis");
		Person victim6 = new Person("Zen");
		

		Circle menu = new Circle();
		menu.addPerson(victim1);
		menu.addPerson(victim2);
		menu.addPerson(victim3);
		menu.addPerson(victim4);
		menu.addPerson(victim5);
		menu.addPerson(victim6);
		
		System.out.println(menu.printPersons());
		
		System.out.println("Removed "+menu.removeFirst());
		System.out.println(menu.removeNext(3));
		

	}

}
