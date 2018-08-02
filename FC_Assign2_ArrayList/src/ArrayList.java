//Fiona Crook
//300442873
//Swen501 - Assignment 2: ArrayList


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ArrayList<E> implements List<E> {
    
	//fields
	private E[] data; 
	private int listSize=0;
	
	public ArrayList() {
		this.data=(E[])new Object[2];
	}
	
	
	/**Core*/
	@Override
	//Appends the specified element to the end of this list
	public boolean add(E input) {				
		if(this.listSize+1>this.data.length) {	
			increaseArray();					
		}
		this.data[listSize]=input;			
		this.listSize++;								
		return true;						
	}

	private void increaseArray() {	
		int newSize=this.listSize*2;
		E[] newData=(E[])new Object[newSize];
		for(int i=0;i<this.data.length;i++) {
			newData[i]=this.data[i];
		}
		this.data=newData;		
	}
	
	private void increaseArrayBy(int inc) {
		int newSize=this.listSize+inc+1;
		E[] newData=(E[])new Object[newSize];
		for(int i=0;i<this.data.length;i++) {
			newData[i]=this.data[i];
		}
		this.data=newData;
	}
	
	/**Core*/
	@Override
	//Inserts the specified element at the specified position in this list
	public void add(int i, E input) {		
		if(i<0 || i>this.listSize) {
			throw new IndexOutOfBoundsException();
		} else {
			if(this.listSize+1>this.data.length) {	
				increaseArray();					
			}
			for(int j=this.listSize-1;j>=i;j--) {
				this.data[j+1]=this.data[j];
			}
			this.data[i]=input;
			this.listSize++;
		}
		
	}

	/**Core*/
	@Override
	//Appends all of the elements in the specified collection to the end of this list
	public boolean addAll(Collection<? extends E> append) {		
		E[] second=(E[]) append.toArray();  
		int secondSize=0;
		if((second.length+this.listSize)>this.data.length) {
			increaseArrayBy(second.length);
		}
		for(int i=0;i<second.length;i++) {	
			if(second[i]!=null) {
				this.data[this.listSize+i]=second[i];
				secondSize++;
			} else {
				break;
			}
		}
		this.listSize+=secondSize;
		return true;
	}

	/**Completion*/
	@Override
	//Inserts all of the elements in the specified collection into this list at the specified position
	public boolean addAll(int in, Collection<? extends E> col) {
		E[] insert=(E[]) col.toArray();
		if(in<0 || in>this.listSize) {
			throw new IndexOutOfBoundsException();
		} else {
			for(int i=0;i<insert.length;i++) {
				add(in+i,insert[i]);
			}
		}	
		return true;
	}

	/**Core*/
	@Override
	//Removes all of the elements from this list
	public void clear() {		
		for(int i=0;i<this.listSize;i++) {	
			this.data[i]=null;
		}
		this.listSize=0;	
	}

	/**Core*/
	@Override
	//Returns true if this list contains the specified element
	public boolean contains(Object obj) {		
		for(int i=0;i<this.listSize;i++) {
			if(this.data[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}

	/**Completion*/
	@Override
	//Returns true if this list contains all of the elements of the specified collection
	public boolean containsAll(Collection<?> col) {
		boolean match=false;
		E[] second=(E[]) col.toArray();		
		for(int i=0;i<second.length;i++) {
			if(contains(second[i])){
				match=true;
			} else {
				match=false;
				break;
			}
		}
		return match;
	}

	/**Core*/
	@Override
	//Returns the element at the specified position in this list
	public E get(int i) {		
		if(i<0 || i>this.listSize) {
			throw new IndexOutOfBoundsException();
		} else {
			return this.data[i];
		}
	}

	/**Completion*/
	@Override
	//Returns the index of the first occurrence of the specified element in this list, 
	//or -1 if this list does not contain the element
	public int indexOf(Object obj) {
		for(int i=0;i<this.listSize;i++) {
			if(this.data[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	/**Core*/
	@Override
	//Returns true if this list contains no elements
	public boolean isEmpty() {		
		if(this.listSize==0) {
			return true;
		}
		return false;
	}

	/**Challenge*/
	@Override
	public Iterator<E> iterator() {
		return new IteratorInnerClass();
		
	}
	
	//inner class
		public class IteratorInnerClass implements Iterator<E>{
			
			private int index=0;
			
			public boolean hasNext() { 		//to check if there is a next object
				if(index<size()) {				//if the index value is less than the size of the train
					return true;			//return true
				} else {					//if the index value is outside
					return false;			//return false
				}
			}
			
			public E next(){				//to return the next object
				if(this.hasNext()) {		//first see if there is a next object				
					@SuppressWarnings("unchecked")
					E[] testArray=(E[]) new Object[size()];		//need to return an array object
					E[] tArray2=toArray(testArray);
					return tArray2[index++];	//if yes, return the next indexed item
				} else {					//otherwise
					return null;			//return nothing
				}
			}
			
			public void remove() {
				
			}
		} //end inner class

	/**Completion*/
	@Override
	//Returns the index of the last occurrence of the specified element in this list, 
	//or -1 if this list does not contain the element
	public int lastIndexOf(Object obj) {			
		for(int i=this.listSize-1;i>=0;i--) {
			if(this.data[i].equals(obj)){
				return i;
			}
		}
		return -1;
	}

	/**Challenge*/
	@Override
	public ListIterator<E> listIterator() {
		return new ListIteratorInnerClass();
		
	}
	
		public class ListIteratorInnerClass implements ListIterator<E>{
	
			private int index=0;
			
			@Override
			public void add(E arg0) {
				// TODO Auto-generated method stub
				
			}
	
			@Override
			public boolean hasNext() {
				if(index<size()) {				
					return true;			
				} else {					
					return false;			
				}				
			}
	
			@Override
			public boolean hasPrevious() {
				if(index>0) {
					return true;
				} else {
					return false;
				}
			}
	
			@Override
			public E next() {
				if(this.hasNext()) {					
					@SuppressWarnings("unchecked")
					E[] testArray=(E[]) new Object[size()];	
					E[] tArray2=toArray(testArray);
					return tArray2[index++];	
				} else {					
					return null;			
				}
			}
	
			@Override
			public int nextIndex() {			
				return index+1;
			}
	
			@Override
			public E previous() {
				if(this.hasPrevious()) {
					E[] testArray=(E[]) new Object[size()];	
					E[] tArray2=toArray(testArray);
					return tArray2[index--];	//<<returning out of bounds exception
				}
				return null;
			}
	
			@Override
			public int previousIndex() {
				// TODO Auto-generated method stub
				return 0;
			}
	
			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
	
			@Override
			public void set(E arg0) {
				// TODO Auto-generated method stub
				
			}
			
		}

	/**Challenge*/
	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**Core*/
	@Override
	//Removes the first occurrence of the specified element from this list
	public boolean remove(Object obj) {	
		for(int i=0;i<this.listSize;i++) {
			if(this.data[i].equals(obj)) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	/**Core*/
	@Override
	//Removes the element at the specified position in this list
	public E remove(int i) {		
		if(i<0 || i>this.listSize) {
			throw new IndexOutOfBoundsException();
		} else {			
			E temp=this.data[i];							
			for(int j=i;j<this.listSize-1;j++) {
				this.data[j]=this.data[j+1];
			}			
			this.listSize--;
			return temp;
		}
	}

	/**Completion*/
	@Override
	//Removes from this list all of its elements that are contained in the specified collection
	public boolean removeAll(Collection<?> col) {
		boolean match=false;
		int matches=0;
		E[] second=(E[]) col.toArray();
		for(int i=0;i<second.length;i++) {		
			if(contains(second[i])){
				remove(second[i]);		
				matches++;
			} 
		}
		if(matches==second.length) {
			return true;
		}
		return false;
		
	}

	/**Challenge*/
	@Override
	//Retains only the elements in this list that are contained in the specified collection
	public boolean retainAll(Collection<?> col) {
		E[] second=(E[]) col.toArray();
		for(int i=this.listSize-1;i>=0;i--) {
			if(!col.contains(this.data[i])) {
				remove(i);
			}
		}
		return true;
	}

	/**Core*/
	@Override
	//Replaces the element at the specified position in this list with the specified element
	public E set(int i, E e) {				
		if(i<0 || i>this.listSize) {
			throw new IndexOutOfBoundsException();
		} else {
			E temp=this.data[i];
			this.data[i]=e;
			return temp;
		}
	}

	/**Core*/
	@Override
	//Returns the number of elements in this list
	public int size() {
		if(this.listSize>Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return this.listSize;
	}

	/**Challenge*/
	@Override
	//Returns a view of the portion of this list between the specified fromIndex, inclusive, 
	//and toIndex, exclusive
	public List<E> subList(int fromI, int toI) {
		if(fromI<0 || toI>this.listSize || toI<fromI) {
			throw new IndexOutOfBoundsException();
		} else {
			List<E> tempList=new ArrayList<E>();
			for(int i=fromI;i<toI;i++) {
				tempList.add(this.data[i]);
			}	
			return tempList;
		}
	}

	/**Completion*/
	@Override
	//Returns an array containing all of the elements in this list
	public Object[] toArray() {
		Object [] tList=new Object[size()];
		for(int i=0;i<size();i++) {
			tList[i]=get(i); 
		}
		return tList;
		
	}

	/**Challenge*/
	@Override
	//Returns an array containing all of the elements in this list
	public <E> E[] toArray(E[] input) {
		@SuppressWarnings("unchecked")	
		E[] tList=(E[]) new Object[size()]; 
		for(int i=0;i<size();i++) {
			tList[i]=(E) get(i);
		}		
		return tList;
		
	}
}