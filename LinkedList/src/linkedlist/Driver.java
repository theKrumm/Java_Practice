package linkedlist;


public class Driver {
	public static void main(String[] theArgs) {
		MyList<Integer> list = new MyList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.addLast(10);
		list.insertAfter(3, 22);
		System.out.println(list.getSize());
		list.printList();
//		int[] ints = {2, 4, 6, 8, 2, 4, 2, 5, 9, 10};
//		MyList list2 = new MyList(ints);
//		System.out.println(list2.getSize());
//		list2.printList();
		list.deleteFirst(1);
		list.printList();
		list.printList();
		System.out.println(list.findMth(1));
	}
}
