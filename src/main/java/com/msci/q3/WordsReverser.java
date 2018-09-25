package com.msci.q3;

public class WordsReverser {

	
	public String reverseWords(String input) {
		if (input==null) {
			return null;
		}
        String[] strs=input.split("\\s+");
        swap(strs, 0, strs.length-1);
        return String.join(" ", strs);
    }
	
	private <E> void swap(E[] input, int i, int j) {
        while (i<j) {
        	E t=input[i];
        	input[i]=input[j];
        	input[j]=t;
            i++;
            j--;
	    }
	}
	
	public void reverseWords(char[] input) {
		if (input==null || input.length<2) {
			return;
		}
		swap(input, 0, input.length-1);
		int i=0;
		for (int j=0; j<input.length; j++) {
			if (input[j]==' ') {
				swap(input, i, j-1);
				i=j+1;
			} else if (j==input.length-1) {
				swap(input, i, j);
			}
		}
	}
	
	private void swap(char[] input, int i, int j) {
        while (i<j) {
        	char t=input[i];
        	input[i]=input[j];
        	input[j]=t;
            i++;
            j--;
	    }
	}
		
	/*
	 * windows console
	 * java -cp "target/msci.questions.jar" com.msci.q3.WordsReverser
	 * 
	 */
	
	public static void main(String[] args) {
        WordsReverser wr=new WordsReverser();
        String input="This is a test";
        System.out.println("Reverse a String :" + input);
        System.out.println(wr.reverseWords(input));
        
        char[] inputArr = {'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 't', 'e', 's', 't'};
        System.out.print("Reverse a char array :");
        for (char c: inputArr) {
        	System.out.print(" '"+c+"'");
        }
        System.out.println();
        wr.reverseWords(inputArr);
        System.out.println(String.valueOf(inputArr));
	}

}
