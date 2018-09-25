package com.msci.q5;

import java.util.List;
import java.util.ArrayList;

public class PascalTriangleHandler {
	
	//row indicates index
	public int coordinatesToValue(int row, int col) {
		if (row<0 || col<0 || col>row) {
			return -1;
		}
		List<Integer> list=getRow(row);
		return list.get(col);
	}
	
	//row indicates index
	public List<Integer> getRow(int row) {
	    List<Integer> list=new ArrayList<>();
	    list.add(1);
	    if (row==0) {
	    	return list;
	    }
	    List<Integer> p=getRow(row-1);
	    for (int i=1; i<p.size(); i++){
	        list.add(p.get(i-1)+p.get(i));
	    }
	    list.add(1);
	    return list;
	}
	
	//rows indicates amount of rows
	public List<List<Integer>> buidTriangle(int rows) {
        List<List<Integer>> out=new ArrayList<>();
        if (rows<1) {
            return out;
        }
        for (int r=1; r<=rows; r++) {
            int t=1; 
            List<Integer> in=new ArrayList<>();
            for (int i=1; i<=r; i++)  {
                in.add(t);
                t=t*(r-i)/i;  
            }
            out.add(in);      
        }
        return out;		
	}
	
	/*
	 * windows console
	 * $ java -cp "target/msci.questions.jar" com.msci.q5.PascalTriangleHandler 10
	 */
	
	public static void main(String[] args) {
		if (args==null || args.length<1) {
			System.out.println("Wrong input arguments");
			return;
		}
		int rows=-1;
		try {
			rows=Integer.parseInt(args[0]);
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid amount of rows");
			return;
		}
		if (rows<=0) {
			System.out.println("Amount of rows should be larger than 0");
		}
		PascalTriangleHandler p=new PascalTriangleHandler();
		List<List<Integer>> list=p.buidTriangle(rows);
		for (List<Integer> l: list) {
			for (Integer i: l) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
