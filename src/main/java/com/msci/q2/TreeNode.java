package com.msci.q2;

public class TreeNode implements Comparable<TreeNode> {
    public char ch;
    public int freq;
    public String code;
    public long time;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char ch, int freq) {
        this.ch=ch;
        this.freq=freq;
        time=System.currentTimeMillis();
    }
    
    @Override
    public int compareTo(TreeNode tn) {
    	if (freq!=tn.freq) {
            return freq-tn.freq;
    	}
    	if (ch!=tn.ch) {
    	    return ch-tn.ch;
        }
    	return (int)(tn.time-time);
    }
}
