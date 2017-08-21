package com.mytest.sjjg;

import java.util.AbstractSequentialList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedList1 <T>  extends AbstractSequentialList<T>
implements List<T>, java.io.Serializable{

	private static class Node <T>{
		private T t;
		private Node<T> next;
		private Node<T> prev;
		
		Node (T t,Node<T> next,Node<T> prev){
			this.t = t;
			this.next = next;
			this.prev = prev;
		}
//		@Override
//		public String toString() {
//			return prev.t+"<--"+t+"-->"+next.t;
//		}
		public String toString() {
			return t.toString();
		}
	}

	//定义第一个结点
	private transient Node<T> first;
	
	private transient Node<T> last;
	
	private int size = 0;
	
	
	
	public boolean add(T t){
		if(first == null){
			initAndAddFirst(t);
		}else{
			addLast(t);
		}
		return true;
			
	}
	
	public T set(int index,T t){
		
		if(index >= size){
			throw new  IndexOutOfBoundsException("超过最大Index");
		}
		else{
			replaceIndex(index,t);
		}
		return t;
	}
	
	public void initAndAddFirst(T t){
		first = new Node<T>(t, null, null);
		last = first;
		last.next = first;
		first.prev = last;
		size++;
	}
	
	
	
	public void addLast(T t){
			Node<T> oldLast = last;
			last = new Node<T>(t, first, oldLast);
			oldLast.next = last;
			first.prev = last;
			oldLast.next = last;
			size++;
	}
	
	/**
	 * 替换节点中的数据
	* @param index 索引位置
	* @param t 元素
	 */
	private void replaceIndex(int index,T t){
			Node<T> old = getNode(index);
			Node<T> newNode = new Node<T>(t, old.next, old.prev);
			old.next.prev = newNode;
			old.prev.next = newNode;
			if(index == 0){
				first = newNode;
			}
			//如果size == 1时last也是first,因此这里不是else if
			if(index == size-1){
				last = newNode;
			}
			
	}
	
	/**
	 * 删除元素并返回当前删除的元素数据
	 */
	public T remove(int index){
		Node<T> indeNd =  getNode(index);
		indeNd.next.prev = indeNd.prev;
		indeNd.prev.next = indeNd.next;
		//当链表只有一个结点为时，清空first及last
		if(size == 1){
			first = null;
			last = null;
			size --;
			return indeNd.t;
		}
		//当index为0时，将first置为他的next
		if(index == 0){
			first = indeNd.next;
		}
		//重置last
		else if(index == size -1){
			last = last.prev;
		}
		
		size --;
		//当删除数据以后,只有一条数据时，last = first;
//		if(size == 1 ){
//			last = first;
//		}
		
		return indeNd.t;
		
	}
	
	


	
	public T get(int index){
		Node<T> node =  getNode(index);
		return node.t;
	}
	
	private Node<T> getNode(int index){
		
		if(index == 0){
			return first;
		}
		if(index == size - 1){
			return last;
		}
		if(index >= size || index < 0){
			throw new  IndexOutOfBoundsException("超过最大Index");
		}
		else{
			//如果index 小于一半从第一个开始遍历
			if(index <= size/2){
				Node<T> indexNode = first;
				for (int i = 0; i < index; i++) {
					indexNode = indexNode.next;
				}
				return indexNode;
			}else{
				Node<T> indexNode = last;
				for (int i = size-1; i > index; i--) {
					indexNode = indexNode.prev;
				}
				return indexNode;
			}
		}
		
	}
	
	
	@Override
	public void add(int index, T t) {
		insertIndex(index, t);
	}
	

	/**
	 * 插入某个位置
	* @param index 位置
	* @param t 元素数据
	 */
	private void insertIndex(int index,T t){

		//如果first为空，则调用初始化并插入首结点
		if(first == null){
			 initAndAddFirst(t);
			 return ;
		}
		//如果index为当前size的值，则自动调用addLast
		if(index == size){
			addLast(t);
			return ;
		}
		//调用插入算法
		//1.取得当前位置旧无素结点
		//2初始化新的元素结点，新结点next为旧元素结点，新结点的prev为旧元素结点的prev
		//3旧元素结点的上一个结点的下一个结点为新元素结点
		//4旧元素的上一个结点为新元素结点
		//5当如果结点的index为0时重置first为当前新元素
		//6 size+1
		Node<T> oldIndexNode = getNode(index);
		Node<T> newIndexNode = new Node<T>(t, oldIndexNode, oldIndexNode.prev);
		oldIndexNode.prev.next = newIndexNode;
		oldIndexNode.prev = newIndexNode;
		if(index == 0){
			first = newIndexNode;
		}
		size++;
	}

	
	

	@Override
	public ListIterator<T> listIterator(int index) {
		return null;
	}

	@Override
	public int size() {
		return size;
	}
	
	
	@Override
	public String toString() {
		
		if(first == null){
			return "empty";
		}
		StringBuilder sb = new StringBuilder("");
		Node<T> t = first;
		for(int i=0;i<size;i++){
			if(i!=0){
				sb.append(", ");
			}
			sb.append(t);
			t = t.next;
		}
		
		return "["+sb.toString()+"]";
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		
		test1();
		test2();
		
	}
	public static void test1(){
		LinkedList1<String> listIntMe = new LinkedList1();
		listIntMe.add("0");
		listIntMe.add("1");
		listIntMe.add("2");
		listIntMe.add("3");
//		listIntMe.add("4");
//		listIntMe.add("5");
//		listIntMe.add("6");
		//
		
//		listIntMe.remove(0);
//		listIntMe.remove(0);
//		listIntMe.remove(0);
//		listIntMe.remove(0);
		listIntMe.add("3XXX");
//		listIntMe.remove(4);
		System.out.println(listIntMe.get(4));
//		listIntMe.add(0, "xx");
//		System.out.println("add 0 --> xx");
//		System.out.println(listIntMe);
//		
//		
////		listIntMe.add(5, "xx");
////		System.out.println("add 0 --> xx");
//		System.out.println(listIntMe);
//		listIntMe.remove(0);
//		System.out.println(listIntMe);
		
//		listIntMe.set(0,"9");
//		listIntMe.set(1, "21");
//		listIntMe.set(5, "10");
//		System.out.println(listIntMe.get(0));
//		System.out.println(listIntMe.get(1));
//		System.out.println(listIntMe.get(5));
		
		
		System.out.println(listIntMe.size());
	}
	public static void test2(){
		LinkedList<String> listIntMe = new LinkedList();
		listIntMe.add("0");
		listIntMe.add("1");
		listIntMe.add("2");
		listIntMe.add("3");
//		listIntMe.add("4");
//		listIntMe.add("5");
//		listIntMe.add("6");
		//
		
		listIntMe.remove(0);
		listIntMe.remove(0);
		listIntMe.remove(0);
		listIntMe.remove(0);
		listIntMe.add("3");
		System.out.println(listIntMe);
//		listIntMe.add(0, "xx");
//		System.out.println("add 0 --> xx");
//		System.out.println(listIntMe);
//		
//		
////		listIntMe.add(5, "xx");
////		System.out.println("add 0 --> xx");
//		System.out.println(listIntMe);
//		listIntMe.remove(0);
//		System.out.println(listIntMe);
		
//		listIntMe.set(0,"9");
//		listIntMe.set(1, "21");
//		listIntMe.set(5, "10");
//		System.out.println(listIntMe.get(0));
//		System.out.println(listIntMe.get(1));
//		System.out.println(listIntMe.get(5));
		
		System.out.println(listIntMe.size());
	}
	

	

	
	
	
	
	
	
}
