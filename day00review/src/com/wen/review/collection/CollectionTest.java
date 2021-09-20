package com.wen.review.collection;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.junit.Test;

public class CollectionTest {

	//colection
	@Test
	public void testCollection(){
		
		Collection<String> list1 = new ArrayList<String>();
		Collection list2 = new ArrayList();
		Collection list3 = new ArrayList();
		
		
//		list1.add(123);
		list1.add("1324234");
		list1.add("defv");
		list1.add(new String("cevcd"));
		
//		System.out.println(list1);
//		System.out.println(list1.size());
//		System.out.println(list1.contains("defv"));
//		System.out.println(list1.contains(new String("cevcd")));
//		list1.remove("defv");
//		Iterator<String> iterator = list1.iterator();
//		for(String str : list1){
//			System.out.println(str);
//		}
//		while(iterator.hasNext()){
//			System.out.println(iterator.next());
//		}
		
		
		list2.add("23");
		list2.add(14232);
		list2.add(false);
		list2.add('A');
		list2.add("1324234");
		list2.add("defv");
		list2.add(new String("cevcd"));
		System.out.println(list2);
		
		list3.add(new String[]{"1232","fedv","ergtrb","dfrge","defv"});
		list3.clear();
		
		list3.add(new int[]{1,2,3,4});
		
//		System.out.println(list3.contains(new int[]{1,2,3,4}));
		
//		System.out.println(list2.containsAll(list1));
		
		boolean remove = list2.remove("23");
//		System.out.println(remove);
		list2.removeAll(list1);
		Object[] array = list2.toArray();
//		System.out.println(array);
		
	}
	
	//list
	@Test
	public void testList(){
		
		 List list = new ArrayList();
		 list.add(12343);
		 list.add("21");
//		 list.add(true);
		 
		 list.add(0, "first");
//		 list.set(2, false);
		 
//		 System.out.println(list.get(2));
		 
//		 ListIterator listIterator = list.listIterator();
//		 while(listIterator.hasNext()){
//			 String str = (String)listIterator.next();
//			 if(str.equals("21")){
//				 list.add("0000");
//			 }
////			 System.out.println(listIterator.next());
//		 }
		 System.out.println("---------------------------");
		 
//		 while(listIterator.hasPrevious()){
//			 System.out.println(listIterator.previous());
//		 }
		
	}
	
	//set
	public void testSet(){
		
		List list = new ArrayList();
		Set set = new HashSet();
		
		list.add("213");
		list.add("dsv");
		list.add("dsv");
		list.add("dsv");
		list.add(2342);
		list.add("3edwcse2e");
		
//		set.add("213");
//		set.add("dsv");
//		set.add("dsv");
//		set.add("dsv");
//		set.add(2342);
//		set.add("3edwcse2e");
//		
		System.out.println(list);
		
	}
	
}
