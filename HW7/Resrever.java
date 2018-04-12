// Cucumber Kids - Kathleen Wong, Bill Ni
// APCS2 pd2
// HW07 -- A Man, A Plan, A Canal: Panama!
// 2018-02-13

public class Resrever{
	public static String reverseN(String s){
		String rtrnStr = "";
		for(int i = s.length(); i > 0; i--){
			rtrnStr += s.substring(i-1,i);
		}
		return rtrnStr;
	}

	public static String reverseLog(String s){
		if(s.length() > 1){
			return (reverseLog(s.substring(s.length() / 2)) + reverseLog(s.substring(0,s.length() / 2)));
		}else{
			return s;
		}
	}

	public static void main(String[] args){
		System.out.println(reverseN("stressed"));
		System.out.println(reverseLog("stressed"));
		System.out.println(reverseN("racecar"));
		System.out.println(reverseLog("racecar"));
	}
}