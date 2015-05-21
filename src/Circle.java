public class Circle {

	private Node<Person> firstPerson;
	
	private int size;

	public Circle() {
		firstPerson = new Node<Person>(null, null);
		firstPerson.next = firstPerson;
		size = 0;
	}

	// add a person to the circle
	public void addPerson(Person p) {
		
		if (size == 0) {
			firstPerson = new Node<Person>(p, firstPerson);
			size++;
		} else if (size == 1) {
			Node<Person> temp = new Node<Person>(p, firstPerson);
			firstPerson.next = temp;
			size++;
		} else {
			Node<Person> temp = new Node<Person>(p, null);

			Node<Person> indexToAdd = firstPerson;
			while (indexToAdd.next != firstPerson) {
				indexToAdd = indexToAdd.next;
			}
			indexToAdd.next = temp;
			temp.next = firstPerson;
			size++;
		}
	}

	// print all persons in the circle
	public String printPersons() {
		StringBuilder sb = new StringBuilder("Menu: ");
		Node<Person> current = firstPerson;
		for (int i = 0; i < size && current != null; i++) {
			sb.append(current.data.toString() + " ");
			current = current.next;
		}
		return sb.toString();
	}

	// remove and return the first person (randomly selected)
	public Person removeFirst() {
		int index = (int) (Math.random() * (size - 1));
		//int index = 5;
		Person result = null;

		if (index == 0) {
			result = firstPerson.data;
			firstPerson = firstPerson.next;

			personAtIndex(size - 1).next = firstPerson;

			size--;

		} else {
			Node<Person> before = personAtIndex(index );
			Node<Person> eaten = before.next;
			Node<Person> after = eaten.next;

			before.next = after;
			firstPerson = after;
			result = eaten.data;
			eaten = null;

			size--;
		}
		return result;
	}

	// remove and return the next person (selected by count) (by 5).
	public Person removeNext(int count) {
		Person result = null;
		Node<Person> toBeeaten = firstPerson;
		System.out.println("to be eaten " + toBeeaten.data);

		if (count > size)
			return null;

		for (int i = 0; i < count-1; i++) {
			toBeeaten = toBeeaten.next;
		}

		Node<Person> before = toBeeaten;
		Node<Person> eaten = before.next;
		Node<Person> after = eaten.next;

		before.next = after;
		firstPerson = before;
		result = eaten.data;

		size--;

		return result;

	}

	private Node<Person> personAtIndex(int index) {
		Node<Person> current = firstPerson;
		for (int i = 0; i < index-1; i++) {
			current = current.next;
		}

		return current;
	}

	// if not static - the inner class can use the instance fields from the
	// outer class and the T
	private static class Node<T> {

		// all fields are visible to the outer class
		private T data; // entry in bag
		private Node<T> next; // link to next node

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

	} // end Node<T> class
}
