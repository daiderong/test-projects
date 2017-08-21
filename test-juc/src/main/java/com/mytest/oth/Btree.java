package com.mytest.oth;

public class Btree  {

	//树的内部类
	private static class  Tree {
		int  val;
		Tree  left;
		Tree  right;
		
		public  Tree(int  t, Tree  left, Tree  right) {
			this.val = t;
			this.left = left;
			this.right = right;
		}
	}
	
	
	private Tree root;
	
		
	
	public  Btree(){
		root = new Tree(-1,null,null);
	} 
	
	
	
	
	
	
	
	public static int getCurSub(Tree tr,int x,int curMinSub,int nearestV){
		int subX = Math.abs(tr.val - x);  
		if(curMinSub == -1){
			subX = curMinSub;
			nearestV = tr.val;
		}
		else if(subX < curMinSub){
			subX = tr.val;
			nearestV = tr.val;
		}
		int neestR = -1;
		if(tr.right != null && x > tr.val){
			neestR =  getCurSub(tr.right,x,subX,nearestV);
		}
		int neestL = -1;
		if(tr.left != null && x < tr.val){
			neestL =   getCurSub(tr.right,x,subX,nearestV);
		}
		
		int subV1 = subX;
		int subV2 = Math.abs(neestL-x);
		int subV3 = Math.abs(neestR-x);
		int min = Math.min(Math.min(subV1, subV2),subV3);
		
		if( subV1 == min)
			return tr.val;
		if( subV2 == min)
			return neestR;
		if( subV3 == min)
			return neestL;
		return nearestV;
		
	}
	
	
	

	
	
	
	
}
