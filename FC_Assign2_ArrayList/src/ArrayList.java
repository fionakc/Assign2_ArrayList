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
		//this.listSize=this.data.length;	//not true. No data equals no list size
	}
	
	
	/**Core*/
	@Override
	public boolean add(E input) {				//to add at end
		if(this.listSize+1>this.data.length) {	//if adding in would put outside limits
			increaseArray();					//increase
		}
		this.data[listSize]=input;			//insert at end of list
		listSize++;								//increase size of list
		return true;							//did the thing, return true
	}

	private void increaseArray() {	//make new array of twice prev size
		int newSize=this.listSize*2;
		E[] newData=(E[])new Object[newSize];
		for(int i=0;i<this.data.length;i++) {
			newData[i]=this.data[i];
		}
		this.data=newData;
		//but listSize is still the same
		
	}
	
	private void increaseArrayBy(int inc) {
		int newSize=this.listSize+inc+1;
		E[] newData=(E[])new Object[newSize];
		for(int i=0;i<this.data.length;i++) {
			newData[i]=this.data[i];
		}
		this.data=newData;
		//but listSize is still the same
	}
	
	/**Core*/
	@Override
	public void add(int i, E input) {		//Inserts the specified element at the specified position in this list
		if(i<0 || i>this.listSize) {
			throw new IndexOutOfBoundsException();
		} else {
			if(this.listSize+1>this.data.length) {	//if adding in would put outside limits
				increaseArray();					//increase
			}
			for(int j=this.listSize-1;j>=i;j--) {
				this.data[j+1]=this.data[j];
			}
			this.data[i]=input;
			listSize++;
		}
		
	}

	/**Core*/
	@Override
	//Appends all of the elements in the specified collection to the end of this list
	public boolean addAll(Collection<? extends E> append) { //turn into array - but how to get new size??		
		E[] second=(E[]) append.toArray();  
		int secondSize=0;
		if((second.length+this.listSize)>this.data.length) {
			//System.out.println("combo "+(second.length+this.listSize));
			//System.out.println("into "+this.data.length);
			increaseArrayBy(second.length);
			//System.out.println("new length "+this.data.length);
			//break;
		}
		for(int i=0;i<second.length;i++) {	//assuming empty elements at end, of type null
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
	public void clear() {		//Removes all of the elements from this list
		for(int i=0;i<this.listSize;i++) {		//this loop maybe not needed??
			this.data[i]=null;
		}
		this.listSize=0;	
	}

	/**Core*/
	@Override
	public boolean contains(Object obj) {		//Returns true if this list contains the specified element
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
		//boolean contain=false;
		E[] second=(E[]) col.toArray();
		//E[] newData=(E[])new Object[this.listSize];
//		for(int i=0;i<this.listSize;i++) {
//			newData[i]=this.data[i];
//		}
//		if(second.length!=newData.length) {
//			return false;
//		}
		
		for(int i=0;i<second.length;i++) {
			//contain=contains(second[i]);
//			if(newData[i].equals(second[i])) {
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
	public E get(int i) {		//Returns the element at the specified position in this list.
		if(i<0 || i>this.listSize) {
			throw new IndexOutOfBoundsException();
		} else {
			return this.data[i];
		}
		
		//return null;
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
	public boolean isEmpty() {		//Returns true if this list contains no elements
		if(this.listSize==0) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**Completion*/
	@Override
	//Returns the index of the last occurrence of the specified element in this list, 
	//or -1 if this list does not contain the element
	public int lastIndexOf(Object obj) {		//or could loop backwards, break when found
//		int num=-1;		
//		for(int i=0;i<this.listSize;i++) {
//			if(this.data[i].equals(obj)) {
//				num=i;
//			}
//		}
//		return num;
		
		for(int i=this.listSize-1;i>=0;i--) {
			if(this.data[i].equals(obj)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**Core*/
	@Override
	public boolean remove(Object obj) {	//Removes the first occurrence of the specified element from this list
		for(int i=0;i<this.listSize;i++) {
			if(this.data[i].equals(obj)) {
				//System.out.println("at index "+i);
				remove(i);
				return true;
			}
		}
		return false;
	}

	/**Core*/
	@Override
	public E remove(int i) {		//Removes the element at the specified position in this list
		if(i<0 || i>this.listSize) {
			throw new IndexOutOfBoundsException();
		} else {			
			E temp=this.data[i];	//make copy of obj being removed						
			for(int j=i;j<this.listSize-1;j++) {
				//System.out.println("index j "+this.data[j]);
				//System.out.println("index j+1 "+this.data[j+1]);
				this.data[j]=this.data[j+1];
			}			
			listSize--;
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
				//System.out.println("removing "+(second[i]));
				remove(second[i]);		
				matches++;
			} 
			
			//remove(second[i]);
		}
		if(matches==second.length) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/**Core*/
	@Override
	public E set(int i, E e) {		//Replaces the element at the specified position in this list with the specified element		
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
	public int size() {
		if(this.listSize>Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return this.listSize;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	/**Completion*/
	@Override
	public Object[] toArray() {
		Object [] tList=new Object[size()];
		for(int i=0;i<size();i++) {
			tList[i]=get(i); //array holds data items
		}
		return tList;
		
	}

	//@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}