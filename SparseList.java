
import java.util.*;

/**
 * A list that behaves as a javascript array. Elements can be added
 * at any non negative index regardless of whether a value exists at the index before the
 * specified index. If there are unspecified indexes in the list they are initialized as 
 * null.
 * @author Yasmin Zamani
 * @author 216491003
 */

public class SparseList<E> implements List<E> 
{
	private Map<Integer,E> myList;
	private E blanks;


/**
 * Creates an empty list of size zero.
 */
	SparseList()
	{
		this.myList = new HashMap<Integer,E>();
	}
/**
 * Creates an empty list of size zero and specifies the contents of null values
 * (the unspecified indexes).
 * @param emptyValue The contents of unspecified indexes.
 */
	SparseList(E emptyValue)   //one parameter which will replace null values
	{
		this.blanks = emptyValue;
		this.myList = new HashMap<Integer,E>();
	}
	
/**
 * Adds the value to the end of the list.
 * @param e The value to add to the end of the list.
 * @return Will return true upon successfully appending.
 */
	public boolean add(E e)   //adds at end, last index + 1 unless list is empty
	{
		
		if (isEmpty())
		{
			add(0, e);
		
		}
		
		else
		{
		
		
		int index = 0;
		
		for (int key : myList.keySet()) //go through all keys (indexes) that were specified
		  {
		    if (key > index)           //find the largest key (index)
		    {
		    	index = key;
		    }
		  }
		
		add(index + 1, e);           //add the element to end, after highest index
		
		}
		
		return true;
	}
/**
 * Adds the value to the specified index in the list.
 * @param index The index in the list.
 * @param element The element or value to be added.
 * @throws IllegalArgumentException If the index is negative.
 */
	public void add(int index, E element)
	{
		
		if (index < 0)
		{
			throw new IllegalArgumentException("Non-Negative Index Only!");
		}
		
		
		for (int i = size() - 1; i >= index; i--)  //start backwards shift element right
		{
			this.myList.put(i + 1, get(i));
		}
		
		
		this.myList.put(index, element);
		
	}
/**
 * Removes the value from the list given the index.
 * @param index The index in the list.
 * @throws IllegalArgumentException If index is negative or does not exist.
 * @return The value that has been removed.
 */
	public E remove(int index)
	{
		
		if (index < 0)
		{
			throw new IllegalArgumentException("Non-Negative Index Only!");
		}
		
		if (index >= size())
		{
			throw new IllegalArgumentException("Index does not exist!");
		}
		
		
		
		E previousValue = get(index);   //the value to remove
	
		
		if(index == size() - 1)         //remove from end of list
		{
			this.myList.remove(index);
		}
		
		else
		{
		
			this.myList.remove(index); //remove value, it becomes null
			
			
	    	for (int i = index; i < size() - 1; i++)  //start at index, shift values left
	    	{
			    this.myList.put(i, get(i + 1));
		    }
		
	    	this.myList.remove(size() - 1);  //remove the last spot which is empty now
		
		}
		
		return previousValue;        //display removed value
	}
	
/**
 * Gets the element / value given the index.
 * @param index The index in the list.
 * @throws IllegalArgumentException If index is negative or does not exist.
 * @return The value associated with the index.	
 */
	public E get(int index)
	{
		
		if (index < 0)
		{
			throw new IllegalArgumentException("Non-Negative Index Only!");
		}
		
		if (index >= size())
		{
			throw new IllegalArgumentException("Index does not exist!");
		}
		
		
		
		if (this.myList.containsKey(index))
		{
			return this.myList.get(index);
		}
		else
		{
			return this.blanks;
		}
		
		
	}
	
/**
 * Sets the element / value given the index. Appropriate to use
 * if meaning to replace an element rather than simply adding it.
 * @param index The index to be set.
 * @param element The element / value to be set at the specified index.
 * @throws IllegalArgumentException If index is negative.
 * @return the previous value set at the specified index.
 */
	public E set(int index, E element)
	{
		if (index < 0)
		{
			throw new IllegalArgumentException("Non-Negative Index Only!");
		}
		
		
		E previousValue = get(index);        //the old element at the index
		
		this.myList.replace(index, element); //puts new element at specified index
		return previousValue;                //returns old element
		
	}
/**
 * The size of the list or number of elements.
 * @return An integer representing the number of elements.
 */
	public int size()                  
	{
		
		
		if (isEmpty())  
		{
			return 0;
		}
		
		else
		{
		
		
		
        int index = 0;
		
		for (int key : this.myList.keySet()) //go through all keys (indexes) that were specified
		  {
		  
			
			if (key > index)           //find the largest key (index)
		    {
		    	index = key;
		    } 
			
			
		  }  
		
		return index + 1;
		
		}
		
		
	}
	
/**
 * Empties the list.
 */
	
	public void clear()
	{
		this.myList.clear();
	}

/**
 * Checks if the list is empty.
 * @return A boolean value true or false. If the list is empty it returns true.
 */
	
	public boolean isEmpty()
	{
		if (this.myList.size() == 0) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	//not needed methods here
	
	/**
	 * Not Supported.
	 */
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not Supported.
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not Supported.
	 */
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not Supported.
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not Supported.
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not Supported.
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not Supported.
	 */
	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not Supported.
	 */
	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not Supported.
	 */
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Not Supported.
	 */
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not Supported.
	 */
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Not Supported.
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not Supported.
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Not Supported.
	 */
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Not Supported.
	 */
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	//not needed methods ends
	
	
	
	
/**
 * Returns a string representation of the list. 
 * @return A string representation of the list enclosed in square brackets.
 */

	
	public String toString()
	{
	
		if (this.myList.isEmpty())
		{
			return "[]";
		}
		
		else
		{
			
		
		String contents = "[";
		
		
		
		for (int i = 0; i < size(); i++)  //search every index to user's last
		{
			
			if(this.myList.containsKey(i))        //if the index is in map, return it
			{
				
				if(i == size() - 1)   //i is last index
				{
					contents += this.myList.get(i);
				}
				else
				{
				
				contents += this.myList.get(i) + ", ";
				}
			}
			else 
			{
				if(i == size() - 1)  //i is last index
				{
					contents += this.blanks;
				}
				else
				{
				contents += this.blanks + ", ";  //else print the null
				}
			} 
		}
		
		contents += "]";
		return contents;
		}
	
	}
	
	
	
	
	/*
	public static void main(String[] args)  
	{
		
		List <String> mylist = new SparseList<>("empty");
		mylist.add("0");
		mylist.add(4,"5");
		System.out.println(mylist.toString()); 
		System.out.println("size:" + mylist.size());
		mylist.add(4,"22");
		mylist.set(1,"44");
		System.out.println(mylist.toString()); 
		System.out.println("size:" + mylist.size());
		System.out.println(mylist.get(5));
		
		System.out.println(mylist.get(4));
		System.out.println(mylist.get(2));
		System.out.println(mylist.remove(0));
		System.out.println(mylist.toString());
		System.out.println("size:" + mylist.size());
		
		System.out.println(mylist.remove(2));
		System.out.println(mylist.toString());
		System.out.println("size:" + mylist.size());
		
		System.out.println(mylist.remove(3));
		System.out.println(mylist.toString());
		System.out.println("size:" + mylist.size());
		
		
		System.out.println("-------------------------");
		
		SparseList<Double> list = new SparseList<Double>();
		list.add(2.5);      //figure out shifting
		list.add(5,3.3);
		list.add(6.0);
		System.out.println(list.toString()); 
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		System.out.println("-------------------------");
		
		SparseList<Double> list2 = new SparseList<Double>();
		System.out.println(list2.isEmpty());
		System.out.println(list2.size());
		System.out.println(list2.toString());
		list2.add(5, 4.3);
		System.out.println(list2.toString());
		
		list2.remove(4);
		System.out.println(list2.toString());
		//System.out.println(list2.get(5));
	    list2.set(-10, 9.2);   
	    System.out.println(list2.toString());
	} */
 
	

	
}
