import java.util.LinkedList;
import java.util.Iterator;

public class LinkedQueue<T> implements QueueInterface<T> , Iterable<T>{
	private int size;
	private Node<T> front;
	private Node<T> back;
	private LinkedList<T> elements = new LinkedList<T>();
 
	public LinkedQueue() {
		front = null;
		back = null;
		size = 0;
	}

	public void enqueue(T newEntry) {
		if (isEmpty()) {
			Node<T> node = new Node<T>(newEntry);
			node.setNext(null);
			front = node;
			back = node;
			size++;
		} else {
			Node<T> node = new Node<T>(newEntry);
			back.setNext(node);
			back = node;
			node.setNext(null);
			size++;
		}
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new Error("Empty Queue");
		}
		T newT = front.getData();
		Node<T> temp = front;
		front = null;
		front = temp.getNext();
		size--;
		return newT;
	}

	public T getFront() {
		if (isEmpty()) {
			throw new Error("Empty Queue");
		} else {
			return front.getData();
		}
	}

	public boolean isEmpty() {
		return (front == null);
	}

	public void clear() {
		front = null;
		back = null;

	}
	public Iterator<T> iterator() {
        return elements.iterator();
    }

	

}
