package com.mytest.nio;

import java.nio.ByteBuffer;

public class TestByteBuffer {

	
	public static void main(String[] args) {
		
		
		ByteBuffer byf = ByteBuffer.allocate(100);
		System.out.println(byf.position());
		System.out.println(byf.limit());
		System.out.println(byf.capacity());
		System.out.println("------------1");
		byf.put(new byte[]{1,2,3,4,5,6,7,8,9,10});
		byf.put(new byte[]{1,2,3,4,5,6,7,8,9,10});
		byf.put(new byte[]{1,2,3,4,5,6,7,8,9,10});
		byf.put(new byte[]{1,2,3,4,5,6,7,8,9,10});
		byf.put(new byte[]{1,2,3,4,5,6,7,8,9,10});
		byf.put(new byte[]{1,2,3,4,5,6,7,8,9,10});
		
		
		System.out.println(byf.position());
		System.out.println(byf.limit());
		System.out.println(byf.capacity());
		
		System.out.println("------------2");
		System.out.println(	byf.flip());
		
		System.out.println(	byf.get());
		System.out.println(byf.position());
		System.out.println(byf.limit());
		System.out.println(byf.capacity());
		
		
		
	}
	
}
