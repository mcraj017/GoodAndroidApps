package com.example.learnmandarin;



public class ResultHandeler {
	static String ColorResult [] = new String[11];
	static String FamilyResult [] = new String[8];
	static String NumeracyResult [] = new String[10];
	static String BodyResult [] = new String[9];
	static String BasiccommResult [] = new String[11];
	static String ShapeResult [] = new String[11];
	

	public static String[] getColorResult() {
		return ColorResult;
	}

	public static void setColorResult(String Result,int count) {
		ColorResult[count-1] = Result;
	}
	public static String[] getFamilyResult() {
		return FamilyResult;
	}

	public static void setFamilyResult(String Result,int count) {
		FamilyResult[count-1] = Result;
	}

	public static void setNumeracyResult(String Result,int count) {
		NumeracyResult[count-1] = Result;
	}
	public static String[] getNumeracyResult() {
		return NumeracyResult;
	}

	public static void setBodyResult(String Result,int count) {
		BodyResult[count-1] = Result;
	}
	public static String[] getBodyResult() {
		return BodyResult;
	}
	public static void setBasiccommResult(String Result,int count) {
		BasiccommResult[count-1] = Result;
	}
	public static String[] getBasiccommResult() {
		return BasiccommResult;
	}
	public static void setShapeResult(String Result,int count) {
		ShapeResult[count-1] = Result;
	}
	public static String[] getShapeResult() {
		return ShapeResult;
	}

	public static int findColorResult()
	{
		String[] ActualResult = {"c","d","a","b","a","a","d","b","d","a","b"};
		int marks=0;
		for(int i=0;i<ColorResult.length;i++)
		{
			if(ActualResult[i].equals(ColorResult[i]))
			{
				marks++;
			}
		}

		return marks;
	}
	
	public static int findFamilyResult()
	{
		String[] ActualResult = {"b","a","d","a","b","c","d","a"};
		int marks=0;
		for(int i=0;i<FamilyResult.length;i++)
		{
			if(ActualResult[i].equals(FamilyResult[i]))
			{
				marks++;
			}
		}
		return marks;
	}
	public static int findNumeracyResult()
	{
		String[] ActualResult = {"c","a","b","a","b","d","b","a","d","c"};
		int marks=0;
		for(int i=0;i<NumeracyResult.length;i++)
		{
			if(ActualResult[i].equals(NumeracyResult[i]))
			{
				marks++;
			}
		}
		return marks;
	}
	
	public static int findBodyResult()
	{
		String[] ActualResult = {"c","d","b","a","c","b","a","b","b"};
		int marks=0;
		for(int i=0;i<BodyResult.length;i++)
		{
			if(ActualResult[i].equals(BodyResult[i]))
			{
				marks++;
			}
		}
		return marks;
	}
	
	public static int findBasiccommResult()
	{
		String[] ActualResult = {"b","a","c","d","d","a","a","c","b","c","c"};
		int marks=0;
		for(int i=0;i<BasiccommResult.length;i++)
		{
			if(ActualResult[i].equals(BasiccommResult[i]))
			{
				marks++;
			}
		}
		return marks;
	}
	
	public static int findShapeResult()
	{
		String[] ActualResult = {"b","b","a","d","a","c","c","d","c","b","a"};
		int marks=0;
		for(int i=0;i<ShapeResult.length;i++)
		{
			if(ActualResult[i].equals(ShapeResult[i]))
			{
				marks++;
			}
		}
		return marks;
	}

}
