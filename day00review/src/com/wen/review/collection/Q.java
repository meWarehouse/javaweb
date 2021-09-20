package com.wen.review.collection;


class Obj<E>{
	private E obj;

	public E getObj() {
		return obj;
	}

	public void setObj(E obj) {
		this.obj = obj;
	}
	
	
	
	
}





public class Q {

	public static void main(String[] args) {
		
		Obj<Integer> o = new Obj<Integer>();
		o.setObj(1324);
//		o.setObj("vsdf");
		
		Obj<String> o1 = new Obj<String>();
		o1.setObj("dcsvf");
		
		
	}
	
	
//	public static void addTest(int a,int ...b){
//		
//	}
//	
//	public void add(int ...a){int sum = 0;
//		for(int b : a){
//			System.out.println(b);
//		}
//	}
//	
//	public  void add(double ...a){double sum = 0;
//		for(double b : a){
//			System.out.println(b);
//		}
//	}
	
	
	
	
	
	public <E> void add(E ...e){
		for(int i = 0;i<e.length;i++){
			System.out.println(e);
		}
	}
	
	
	
	
	
	
}
