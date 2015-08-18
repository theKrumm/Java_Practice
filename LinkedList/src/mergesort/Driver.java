package mergesort;


public class Driver {
	public static void main(String[] theArgs) {
		MyList<Integer> list = new MyList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.addLast(10);
		list.insertAfter(3, 22);

	}
}
