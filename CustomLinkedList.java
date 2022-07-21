package com.monocept.model;

import java.util.Iterator;

public class CustomLinkedList<T> implements Iterable<T> {
	Node<T> head;

	public void add(T data) {
		Node newnode = new Node(data);
		if (head == null) {
			head = newnode;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newnode;

	}

	public void addAtPos(T data, int pos) {

		if (pos <= 0 || isEmpty()) {
			return;
		}
		Node newnode = new Node(data);
		if (pos == 1) {
			newnode.next = head;
			head = newnode;
			return;
		}
		if (pos - 1 == getSize()) {
			add(data);
			return;
		}
		int count = 2;
		Node temp = head.next;
		Node prev = head;
		while (temp.next != null) {
			if (count == pos) {
				prev.next = newnode;
				newnode.next = temp;
				return;
			}
			count++;
			prev = temp;
			temp = temp.next;
		}
		if (pos == getSize()) {
			prev.next = newnode;
			newnode.next = temp;
			return;
		}

	}

	public void addFirst(T data) {
		Node<T> newnode = new Node(data);
		newnode.next = head;
		head = newnode;

	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public int getSize() {
		int countSize = 0;
		Node<T> temp = head;
		if (isEmpty()) {
			return 0;
		}
		while (temp != null) {
			countSize++;
			temp = temp.next;
		}
		return countSize;

	}

	public boolean removeLast() {
		if (isEmpty()) {
			return false;
		}
		if (getSize() == 1) {
			head = null;
			return true;
		}
		Node<T> temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return true;

	}

	public boolean remove(T data) {
		boolean flag = false;
		if (isEmpty()) {
			return flag;
		}
		if (head.data == data) {
			head = head.next;
			return true;
		}
		Node<T> temp = head.next;
		Node<T> prev = head;
		while (temp != null) {
			if (temp.data == data) {
				prev.next = temp.next;
				temp = temp.next;
				flag = true;
				continue;
			}
			temp = temp.next;
			prev = prev.next;
		}

		return flag;
	}

	public boolean removeFirst() {
		if (isEmpty()) {
			return false;
		}
		head = head.next;
		return true;
	}

	public boolean removeAtPos(int pos) {
		if (isEmpty()) {
			return false;
		}
		if (pos > getSize() || pos <= 0) {
			return false;
		}
		if (pos == 1) {
			head = head.next;
			return true;
		}
		Node<T> temp = head.next;
		Node<T> prev = head;
		int count = 2;
		while (temp != null) {
			if (count == pos) {
				prev.next = temp.next;
				return true;
			}
			count++;
			prev = prev.next;
			temp = temp.next;
		}
		return false;

	}

	public void display() {
		if (isEmpty()) {
			System.out.println("LinkedList is Empty");
			return;
		}
		Node<T> temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp.data);

	}

	public Node<T> getHead() {
		return head;
	}

	public Iterator<T> iterator() {
		return new ListIterator<T>(this);
	}
}

class ListIterator<T> implements Iterator<T> {
	Node<T> current;

	public ListIterator(CustomLinkedList<T> list) {
		current = list.getHead();
	}

	public boolean hasNext() {
		return current != null;
	}

	public T next() {
		T data = current.getData();
		current = current.getNext();
		return data;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}

class Node<T> {
	T data;
	Node<T> next = null;

	public Node(T data) {
		this.data = data;
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public Node<T> getNext() {
		return next;
	}
}
