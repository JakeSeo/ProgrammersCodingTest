package level_3;

public class LongestPalindrome {
	public boolean checkPalindrome(int startIndex, int length, String s) {
		for(int i = startIndex; i < startIndex + length / 2; i++) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(startIndex + (length - 1) - (i - startIndex));
			if(c1 != c2) {
				return false;
			}
		}
		
		return true;
	}
	
    public int solution(String s) {
        
        for(int i = s.length() - 1 ; i >= 0; i--) {
        	for(int j = 0; j < s.length() - i; j++) {
        		if(checkPalindrome(j, i + 1, s)) {
        			return i + 1;
        		}
        	}
        }

        return -1;
    }
    
    public static void main(String[] args) {
    	LongestPalindrome lp = new LongestPalindrome();
    	
    	String s = "ecdabbeadc";
    	
    	System.out.println(lp.solution(s));
    }

}
