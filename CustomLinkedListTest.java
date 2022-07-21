package com.monocept.test;

import com.monocept.model.CustomLinkedList;

public class CustomLinkedListTest {
	public static void main(String[] args) {
		// Create customLinkedList
		CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();

		// ADD
		// adding at the end of the linkedlist
		System.out.println("Adding 1 2 3 in customLinkedList");
		customLinkedList.add(1);
		customLinkedList.add(2);
		customLinkedList.add(3);

		// DISPLAY
		customLinkedList.display();
		System.out.println();

		// addFirst
		System.out.println("Adding 50 as First Element");
		customLinkedList.addFirst(50);
		customLinkedList.display();
		System.out.println();

		// addAtPos
		System.out.println("Add 100 in 1st Position");
		customLinkedList.addAtPos(100, 1);
		customLinkedList.display();
		System.out.println();

		// REMOVE
		// remove
		System.out.println("Remove element 3 from customLinkedList");
		customLinkedList.remove(3);
		customLinkedList.display();
		System.out.println();

		// removeFirst
		System.out.println("Remove the First Element from customLinkedList");
		customLinkedList.removeFirst();
		customLinkedList.display();
		System.out.println();

		// removeLast
		System.out.println("Remove Last element from customLinkedList");
		customLinkedList.removeLast();
		customLinkedList.display();
		System.out.println();

		// ITERATE
		// Iterate through the customLinkedList using For Each Loop
		System.out.println("Iterate by For-Each Loop");
		for (Integer elements : customLinkedList)
			System.out.print(elements + " ");
		System.out.println();
	}
}
