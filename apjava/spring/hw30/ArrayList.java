import java.util.Iterator;
public class ArrayList<E> implements List<E> {

	// instance variables
	private E[] data; // generic array used for storage
	private int size; // current number of elements

	// constructors
	// Will generate compiler warnings regarding unsafe operations
	// Creates a default ArrayList with a capacity of 16 elements
	public ArrayList() {
		this(10);
	}

	// starting capacity
	public ArrayList(int capacity) {
		data = (E[]) (new Object[capacity]);
		size = 0;
	}

	// returns the number of elements in the list
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// pre: newCapacity > data.length
	// post: simulates a dynamic array
	private void resize(int newCapacity) {
		E[] temp = (E[]) (new Object[newCapacity]);
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
			data[i] = null;
		}
		System.out.println("Resizing from " + data.length + " to " + data.length * 2);
		data = temp;
	}

	// O(1)
	public boolean add(E value) {
		if (size() == data.length)
			resize(data.length * 2);
		data[size++] = value;
		return true;
	}

	// O(1)
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size())
			throw new IndexOutOfBoundsException();
		return data[i];

	}

	// O(1)
	public E set(int i, E value) throws IndexOutOfBoundsException {
		E ans = get(i);
		data[i] = value;
		return ans;
	}

	// O(n)
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size())
			throw new IndexOutOfBoundsException();
		E ans = get(i);
		// shift left
		while (i < size() - 1) {
			data[i] = data[i + 1];
			i++;
		}
		data[size() - 1] = null;
		size--;
		return ans;
	}

	// O(n)
	public void add(int i, E value) throws IndexOutOfBoundsException {
		if (size() == data.length)
			resize(2 * data.length);
		if (i < 0 || i > size())
			throw new IndexOutOfBoundsException();
		// shift right
		for (int j = size(); j > i; j--)
			data[j] = data[j - 1];
		data[i] = value;
		size++;
	}

	public String toString() {
		String ans = "[";
		for (int i = 0; i < size(); i++)
			ans += data[i] + ",";
		if (!isEmpty())
			ans = ans.substring(0, ans.length() - 1);
		ans += "]";
		return ans;
	}

	public Iterator<E> iterator() {
		return new ListIterator<E>(this);
	}

	private class ListIterator<E> implements Iterator<E> {
		ArrayList<E> myList;
		int i;
		public ListIterator(ArrayList<E> list){
			myList = list;
			i = 0;
		}

		public boolean hasNext() {
			return i + 1 < myList.size();
		}

		public E next() {
			i++;
			return myList.get(i);
		}

	}

	public static void main(String[] args) {
		List<Integer> L1 = new ArrayList<Integer>();
		final int N = 100000;
		for (int i = 0; i < N; i++)
			L1.add(i);

		/*
		 * while (!L1.isEmpty()){ int rPos = (int)(Math.random() * L1.size());
		 * System.out.println(L1.remove(rPos) + " " + L1); }
		 */

		// Traversal Demo: Linear performance
		System.out.println("Traversing the list of " + N + " elements with an iterator");
		Iterator<Integer> itr = L1.iterator();
		while (itr.hasNext()) {
			itr.next();
		}
		System.out.println("Done");

		// Traversal Demo : Quadratic performance
		System.out.println("Traversing the list of " + N + " elements with get(int i)");
		for (int i = 0; i < N; i++)
			L1.get(i);
		System.out.println("Done");
	}
}
