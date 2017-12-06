import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedStack<T> implements StackInterface<T>, Iterable<T> {
	private Node<T> head;
	private int index;
	private LinkedList<T> elements = new LinkedList<T>();

	public LinkedStack() {
		head = null;
	}

	public void push(T newEntry) {
		if (head == null) {
			head = new Node<T>(newEntry);
			index++;
		} else {
			Node<T> oldNode = head;
			head = new Node<T>(newEntry, oldNode);
			index++;
		}
		index++;

	}

	public T pop() {
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			index--;
			Node<T> temp = head;
			head = head.getNext();
			return temp.getData();
		}
	}

	public T peek() {
		if(isEmpty())
			throw new EmptyStackException();
		else{
			return head.getData();
		}
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void clear() {		
		head = null;
	}
	
	public int getSize()
	{
		return index;
	}
	public Iterator<T> iterator() {
        return elements.iterator();
    }
}
