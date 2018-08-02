import java.util.Iterator;
import java.util.ListIterator;

public class test {

	public static void main(String[] args) {					//v
		ArrayList<String> test=new ArrayList<>();	
		ArrayList<String> test2=new ArrayList<>();
		
		//System.out.println(test.isEmpty());
		//System.out.println(test.size());
		test.add("a");
		test.add("b");
		//System.out.println(test.isEmpty());
		//System.out.println(test.size());
		test.add("c");
		test.add("d");
		//System.out.println(test.get(2));
		//System.out.println(test.get(3));
		
		//test.add(2,"e");
//		test.add("e");
//		test.add("f");
//		test.add("g");
		
		//System.out.println(test.get(2));
		//System.out.println(test.get(3));
		//System.out.println(test.size());
		
		System.out.println("Print list");
		for(int i=0;i<test.size();i++) {
			System.out.println(test.get(i));
		}
		
		//System.out.println(test.remove("d"));
		
		
		
		//test.clear();
		//System.out.println(test.size());
		
		//System.out.println(test.contains("e"));
		//System.out.println(test.contains("f"));
		
//		test2.add("a");
//		test2.add("e");
//		test2.add("c");
//		test2.add("d");
//		test2.add("w1");
//		test2.add("x1");
//		test2.add("y1");
//		test2.add("z1");
		//test2=(ArrayList)test.subList(1, 3);
//		System.out.println("Print list2");
//		for(int i=0;i<test2.size();i++) {
//			System.out.println(test2.get(i));
//		}
		
		//test.addAll(test2);
		//System.out.println(test.indexOf("c"));
		//System.out.println(test.removeAll(test2));
		//test.addAll(2,test2);
//		test.retainAll(test2);
		
//		
		System.out.println("Print list");
		for(int i=0;i<test.size();i++) {
			System.out.println(test.get(i));
		}
		//System.out.println(test.lastIndexOf("a"));
//		System.out.println(test.size());
		
//		System.out.println("Testing iterator");
//		ArrayList<String> tI=new ArrayList<>();
//		tI.add("w");
//		tI.add("x");
//		tI.add("y");
//		tI.add("z");
//		//System.out.println("created new arraylist");
//		//Iterator<String> iterator=tI.iterator();
//		ListIterator<String> listit=tI.listIterator();
//		//System.out.println("created iterator");
//		while(listit.hasNext()) {
//			//System.out.println("while has next");
//			String nextVal=listit.next();
//			//System.out.println("found next");
//			System.out.println("The next value with Iterator is: "+nextVal);
//		}
//		System.out.println("backwards");
//		while(listit.hasPrevious()) {
//			//System.out.println("while has next");
//			String nextVal=listit.previous();
//			//System.out.println("found next");
//			System.out.println("The next value with Iterator is: "+nextVal);
//		}
	}
	
}
