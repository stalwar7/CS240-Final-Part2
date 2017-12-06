import java.util.Iterator;

/*************************************************************************
 * Winter 2017 CS 240 Programming Exam : Person
 * 
 * Author: Sana Talwar
 * 
 * Dependencies: Stack, Queue, Dictionary
 * 
 * Description: Models a person, a list of messages that they can read, and a
 * list of their friends, so that when you post a message, all your friends can
 * read it too.
 * 
 **************************************************************************/

public class Person {
	private String name;
	private LinkedQueue<Person> listOfFriends;
	private LinkedStack<String> messages;

	// Create a new Person with this name.
	// initialize vars
	public Person(String name) {
		// Person person1 = new Person(name);
		this.name = name;
		this.listOfFriends = new LinkedQueue<Person>();
		this.messages = new LinkedStack<String>();
	}

	// Make these two people become friends with each other.
	// Throw an exception if you try to meet yourself.
	// We are allowed to assume we didn't meet this person yet.
	public void meet(Person otherPerson) {
		if (this.equals(otherPerson)) {
			throw new RuntimeException();
		} else {
			// add friend
			listOfFriends.enqueue(otherPerson);
			// add yourself to other person's list
			otherPerson.listOfFriends.enqueue(this);
		}

	}

	// Are these two people friends?
	// Throw an exception if you ask about knowing yourself.
	public boolean knows(Person otherPerson) {
		if (otherPerson == this) {
			throw new RuntimeException();
		} else {
			// no for loop
			/*
			 * Person person = listOfFriends.getFront()
			 * while(listOfFriends.getFront() != null) { if(otherPerson ==
			 * listOfFriends.getFront()) return true; person =
			 * getFront().getNext(); }
			 */
			/*List<Person> iter = new ArrayList<Person>();
			for(Person person : listOfFriends)
				iter.add(person);
			*/
			for (Person person : listOfFriends ) {
				if (person == otherPerson){
					return true;}
			}
		}
		return false;
	}

	// Post a message to my list and the lists of all my friends
	//stack push
	public void post(String message) {
		 	messages.push(message); 
	        for (Person p : listOfFriends){
	            p.messages.push(message);}

	}

	// Print a header, then all messages this Person can read, newest first
	public void listMessages() {
		System.out.println("== The wall of " + name + " ==");
		for(String msg : messages)
		{
			System.out.println(msg);
		}
	}
}