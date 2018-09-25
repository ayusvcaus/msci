package com.msci.q1;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PhoneNumberDecoder {
	
	public static List<Set<String>> keyborad=new ArrayList<Set<String>>() {{
			add(new HashSet<String>(){{
				add("");   //0
			}});
			add(new HashSet<String>(){{
				add("");   //1
			}});
			add(new HashSet<String>(){{
		        add("A");  //2
		        add("B");
		        add("C");
			}});
			add(new HashSet<String>(){{
		        add("D");  //3
		        add("E");
		        add("F");
			}});
			add(new HashSet<String>(){{
		        add("G");  //4
		        add("H");
		        add("I");
			}});
			add(new HashSet<String>(){{
		        add("J");  //5
		        add("K");
		        add("L");
			}});
			add(new HashSet<String>(){{
		        add("M");  //6
		        add("N");
		        add("O");
			}});
			add(new HashSet<String>(){{
		        add("P");  //7
		        add("Q");
		        add("R");
		        add("S");
			}});
			add(new HashSet<String>(){{
		        add("T");  //8
		        add("U");
		        add("V");
			}});
			add(new HashSet<String>(){{
		        add("W");  //9
		        add("X");
		        add("Y");
		        add("Z");
			}});
	}};
	
	public String wordsFile;
	public final String dictFile="data/dictionary";
	
	public Map<String, Set<String>> dictionary;
	
	public Set<String> getWords(String wordsFile) {
		Set<String> words=new HashSet<>();
		if (wordsFile==null || "".equals(wordsFile)) {
			return words;
		}
		FileReader fileReader=null;
		try {
			fileReader = new FileReader(new File(wordsFile));
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			String line="";
			while ((line=bufferedReader.readLine())!=null) {
				words.add(line.trim().toUpperCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader!=null) {
				try {
				   fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return words;
	}
	
	public void buildDictionary() {
		Set<String> words=getWords(wordsFile);
		dictionary= getDictionary(words);
	}
	
	public Map<String, Set<String>> getDictionary(Set<String> words) {
		 Map<String, Set<String>> dict= new HashMap<>();
        for (String word: words) {
            StringBuilder keyBuilder=new StringBuilder();
            for (char ch : word.toCharArray()) {
                for (int j=0; j<keyborad.size(); j++) { 
                    if (keyborad.get(j).contains(ch+"")) {
                        keyBuilder.append(j);
                    }
                }
            }	            
            String key=keyBuilder.toString();
            if (dict.containsKey(key)) {
            	Set<String> ws=dict.get(key);
            	ws.add(word);
            } else {
            	Set<String> ws=new HashSet<>();
            	ws.add(word);
            	dict.put(key, ws);
            }
        } 
		return dict;
	}
    
    public Set<String> lookup(String num) {
    	Set<String> res=new HashSet<>();
    	if (num==null || "".equals(num)) {
    		return res;
    	}
    	num=num.trim();
    	num=num.replaceAll("[-|(|)|\\s+]", "");

      	if (num.length()>20) {
      		return res;
      	}
    	for (char c: num.toCharArray()) {
    		if ('0'-c>0 || c-'9'>0) {
    			return res;
    		}
    	}
    	dfs(num, "", res);
    	return res;
    }
    
    public void dfs(String num, String in, Set<String> res) { 
    	if (num.length()==0) {
    		res.add(in);
    		return;
    	}
        for (int i=num.length(); i>0; i--) {
            String s=num.substring(0, i); 
            Set<String> ws=dictionary.get(s);
            if (ws!=null) {
            	for (String str: ws) {
            		dfs(num.substring(i), in+str, res);
            	} 
            } else {
            	if (i==1) { //in case the dictionary does not contain single characters, or s in {'0', '1'}
            		dfs(num.substring(i), in+s, res);
                }  
            }
        }
    }
    
    public void setWordsFile(String s) {
    	wordsFile=s;
    }

	/*
	 * windows console:
	 * java -cp "target/msci.questions.jar" com.msci.q1.PhoneNumberDecoder data/google-10000-english-usa.txt 56835282 | grep LOVEJAVA
	 * 
	 */    
    
    public static void main(String[] args) {
    	if (args==null || args.length<2 || "".equals(args[0]) || "".equals(args[1])) {
    		System.out.println("Wrong input aruments!");
    		return;
    	}
    	PhoneNumberDecoder pnd=new PhoneNumberDecoder();
    	pnd.setWordsFile(args[0]);
    	pnd.buildDictionary();
    	Set<String> set=pnd.lookup(args[1]);
    	System.out.println(set);
    }
}
