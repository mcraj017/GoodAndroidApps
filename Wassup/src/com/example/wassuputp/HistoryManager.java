package com.example.wassuputp;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;





public class HistoryManager {
	
	

	public static HashSet<String> RecreateHistory(Set<String> set,String category){
		
		HashSet<String> newset = new HashSet<String>();
			
		set.remove(category);
		Iterator<String> values = set.iterator();
		String value;
		
		int i =0;
		while(values.hasNext()&&i<3)
		{
			value = values.next();
			newset.add(value);
			i++;
		}
		
		return newset;
	}
public static HashSet<String> createHistory(Set<String> set,String category){
		
		HashSet<String> newset = new HashSet<String>();


		if(set.isEmpty())
		{
			newset.add(category);
			return newset;
		}
		
		newset.add(category);
		newset.addAll(set);
		return newset;
	}
	
}
