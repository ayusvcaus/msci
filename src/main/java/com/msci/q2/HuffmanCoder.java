package com.msci.q2;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;

import com.msci.q2.TreeNode;

public class HuffmanCoder {

    private final int ascii=128;
    private TreeNode root;
    
    private TreeNode buildHuffmanTree(String s) {
    	int[] freq=new int[ascii];
    	int n=0;
        for (int i=0; i<s.length(); i++) {
            freq[s.charAt(i)]++;
            if (freq[s.charAt(i)]==1) {
            	n++;
            }
        } 	
        PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>(n);
        for (char i=0; i<ascii; i++) {
            if (freq[i]>0) {
                pq.offer(new TreeNode(i, freq[i]));
            }
        }
        if (pq.size()==1) {
        	TreeNode tn=pq.poll();
        	tn.code="0";
        	return tn;
        }
        while (pq.size()>1) {
            TreeNode one=pq.poll();
            TreeNode two=pq.poll();            
            TreeNode parent=new TreeNode('\0', one.freq+two.freq);
            parent.left=one;
            parent.right=two;
            pq.offer(parent);
        }
        return pq.poll();
    }
    
    public String encode(String in) {
    	if (in==null || "".equals(in) ) {
    		return "";
    	}
    	in=in.trim();
    	root=buildHuffmanTree(in);
        String[] table=new String[ascii];
        printTree(table, root, "");
        String out="";
        for (int i=0; i<in.length(); i++) {
        	out+=table[in.charAt(i)];
        }
        return out;
    }   

    private void printTree(String[] table, TreeNode t, String path) {
        if (t.left!=null && t.right!=null) { //Huffman tree node always has either 2 children or no children
        	printTree(table, t.left,  path+'0');
        	printTree(table, t.right, path+'1');
        } else {
        	if (path.length()>0) {
        	    t.code=path;
        	} 
        	table[t.ch]=t.code;
        }
    }
    
    public String decode(String code) {
    	if (code==null || "".equals(code) ) {
    		return "";
    	}
    	String[] res={""};
    	int start=0;
        int end=1;
        while (end<=code.length()) {
        	boolean[] target={false};
            String s=code.substring(start, end);
            match(root, s, res, target);            
            if (target[0]) {
                start=end;
            }
            end++;
        }
        return res[0];	
    }
    
    private void match(TreeNode root, String code, String[] res, boolean[] target){
        if (root.left==null && root.right==null) {
            if (code.equals(root.code)) {
                res[0]+=""+root.ch; 
                target[0]=true;
                return;
            }
        }
        if (root.left!= null) {
            match(root.left, code, res, target);
        }
        if (root.right!=null) {
            match(root.right, code, res, target);
        }
    }
    /*
     * windows console:
     * 
     * java -cp "target/msci.questions.jar" com.msci.q2.HuffmanCoder "aaabcd"
     */
    public static void main(String[] args) {
    	if (args==null || args.length<1 || "".equals(args[0])) {
    		System.out.println("Wrong input arguments!");
    		return;
    	}
    	HuffmanCoder hc=new HuffmanCoder();
    	TreeNode tn=hc.buildHuffmanTree(args[0]);
    	Set<Character> set=new HashSet<>();
    	for (char c: args[0].toCharArray()) {
    		set.add(c);
    	}
    	char[] cs=new char[set.size()];
    	int k=0;
    	for (char c: set) {
    		cs[k++]=c;
    	}    	
    	Arrays.sort(cs);
    	String[] table=new String[hc.ascii];
        hc.printTree(table, tn, "");
        for (int i=cs.length-1; i>=0; i--) {
        	System.out.print(cs[i]+" = ");
        	char[] tb=table[cs[i]].toCharArray();
        	for (int j=0; j<tb.length; j++) {
        	    System.out.print(tb[j] + (j<tb.length-1 ? ", " : ""));
        	}
        	System.out.println();	      	
        }
    }
}
