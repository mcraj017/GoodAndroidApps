package com.example.learnmalay;


public class ResultHandeler {
	static String UserName = null;
	static String DictionaryResult [] = new String[5];
	static String VerbResult [] = new String[9];
	static String GrammarResult [] = new String[13];
	

	public static String[] getDictionaryResult() {
		return DictionaryResult;
	}

	public static void setDictionaryResult(String Result,int count) {
		DictionaryResult[count] = Result;
	}
	public static String[] getVerbResult() {
		return VerbResult;
	}

	public static void setVerbResult(String Result,int count) {
		VerbResult[count] = Result;
	}

	public static void setGrammarResult(String Result,int count) {
		GrammarResult[count] = Result;
	}
	public static String[] getGrammarResult() {
		return GrammarResult;
	}

	
	public static int findDictionaryResult()
	{
		int marks=0;
		for(int i=0;i<DictionaryResult.length;i++)
		{
			if(DictionaryResult[i].equals("a"))
			{
				marks++;
			}
		}

		return marks;
	}
	
	public static int findVerbResult()
	{
		String[] ActualResult = {"a","b","a","b","b","a","a","a","a"};
		int marks=0;
		for(int i=0;i<VerbResult.length;i++)
		{
			if(ActualResult[i].equals(VerbResult[i]))
			{
				marks++;
			}
		}
		return marks;
	}
	public static int findGrammarResult()
	{
		String[] ActualResult = {"a","b","a","a","b","a","a","b","c","b","a","a","a"};
		int marks=0;
		
		for(int i=0;i<GrammarResult.length;i++)
		{
			System.out.println(GrammarResult[i]);
			if(ActualResult[i].equals(GrammarResult[i]))
			{
				marks++;
			}
		}
		return marks;
	}
	
}

