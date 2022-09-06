package LeetCodes;

public class Test {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = null;
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {  
                    cnt += 2;
                    
                    if (arr == null) {          
                        arr = new int[cnt];
                        
                        arr[0] = i;
                        arr[1] = j;
                    }
                    else {
                        boolean isDuplicated = false;
                        
                        for (int k = 0; k < arr.length; k++) {
                            if (arr[k] == i) {
                                cnt--;
                                isDuplicated = true;
                                break;
                            }
                        }
                        
                        int[] temp = new int[cnt];
                        
                        for (int k = 0; k < arr.length; k++) {
                            temp[k] = arr[k];
                        }
                        
                        if (!isDuplicated) {
                            temp[temp.length - 2] = j;
                        }
                        
                        temp[temp.length - 1] = j;
                        
                        arr = temp;
                    }
                }
            }
        }
        
        return arr;
    }
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numOfItems = nums1.length + nums2.length;
        int[] merge = new int[numOfItems];
        int n1_idx = 0, n2_idx = 0;
        int idx = 0;
        
        while (n1_idx < nums1.length && n2_idx < nums2.length) {
            if (nums1[n1_idx] <= nums2[n2_idx]) {
                merge[idx++] = nums1[n1_idx++];
            }
            else {
                merge[idx++] = nums2[n2_idx++];
            }
        }
        
        while (n1_idx < nums1.length) {
            merge[idx++] = nums1[n1_idx++];
        }
        
        while (n2_idx < nums2.length) {
            merge[idx++] = nums2[n2_idx++];
        }
        
        if (numOfItems % 2 == 0) {
            return (double)(merge[merge.length / 2 - 1] + merge[merge.length / 2]) / 2;
        }
        else {
            return (double)merge[merge.length / 2];
        }
    }
    
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int cnt = 0;
        int sIdx = 0;
        
        String subString = "" + s.charAt(sIdx);
        
        for (int i = 1; i < s.length(); i++) {
            boolean isSame = false;
            for (int j = 0; j < subString.length(); j++) {
                if (subString.charAt(j) == s.charAt(i)) {
                    isSame = true;
                    cnt = (subString.length() - 1) - j;
                    break;
                }
            }
            
            if (isSame) {
                sIdx = i - cnt;
            }
            if (maxLength < subString.length()) {
                maxLength = subString.length();
            }
            subString = s.substring(sIdx, i + 1);
        }

        if (maxLength < subString.length()) {
            maxLength = subString.length();
        }

        return maxLength;
    }

    

    /*
    public int[] qwetwoSum(int[] nums, int target) {
        int cnt = 0; 
        
        int[] idxArr = null;

        for (int i = 0; i < nums.length / 2; i++) {
            int minNum = nums[i];
            int mid = (i + nums.length) / 2;
            int value = minNum + nums[mid];
            
            while (value != target) {
                if (target > value) {
                    mid += nums.length;
                }
                else {
                    mid += i;
                }
                mid /= 2;

                //if ()
            } 
            
           

        }
        
        return idxArr;
    }
    */
    public static String longestPalindrome(String s) {
        String pStr = "" + s.charAt(0);
        int length = s.length();

        
        for (int i = 1; i < length; i++) {
            String temp = "";
            char cur = s.charAt(i);
            char prevChar, nextChar;
            int startIdx = i;
            int prevIdx = i - 1;
            int nextIdx = i + 1;
        
            if (length == 2) {
                prevChar = s.charAt(prevIdx);

                if (cur == prevChar) {
                    pStr = s;
                }
                return pStr;
            }

            while (prevIdx >= 0 && nextIdx < length) {
                prevChar = s.charAt(prevIdx);
                nextChar = s.charAt(nextIdx);
                
                
                if (prevChar == nextChar) {
                    startIdx = prevIdx;
                    prevIdx--;
                    nextIdx++;
                }
                else {
                    temp = s.substring(startIdx, nextIdx);

                    if (temp.length() % 2 == 0) {
                        if (cur == nextChar) {  
                            nextIdx++;
                        }
                        else if (cur == prevChar) {
                            startIdx = prevIdx;
                            prevIdx--;
                        }
                        else {
                            break;
                        }
                    }
                } 

            }
            temp = s.substring(startIdx, nextIdx);

            if (temp.length() % 2 == 0) {
                while (prevIdx >= 0) {
                    prevChar = s.charAt(prevIdx);

                    if (cur == prevChar) {
                        startIdx = prevIdx;
                        prevIdx--;
                    }
                    else {
                        break;
                    }
                }
            
                while (nextIdx < length) {
                    nextChar = s.charAt(nextIdx);

                    if (cur == nextChar) {
                        nextIdx++;
                    }
                    else {
                        break;
                    }
                }
            }

            temp = s.substring(startIdx, nextIdx);
            
            if(pStr.length() < temp.length()) {
                pStr = temp;
            }
        }
        return pStr;
    }

    public static String longestPalindromebeta(String s) {
        int lastIdx = s.length() - 1;
        String result = "";

        for (int i = 0; i <= lastIdx; i++) {
            if (result.length() > lastIdx - i) {
                break;
            }

            boolean isPalindrome = false;
            int m = i;
            int n = lastIdx;
            
            // initialize
            int start = m;
            int last = m + 1;
            int prev;
            String temp = "";
            // bacabab
            while (m <= n) {
                char sCh = s.charAt(m);
                char lCh = s.charAt(n);

                if (sCh == lCh) {
                    if (!isPalindrome) {
                        isPalindrome = true;
                        last = n + 1;
                    }
                    m++;
                }
                else {
                    if (isPalindrome) {
                        m = i;
                        n++;
                        last = m + 1;
                        isPalindrome = false;
                        continue;
                    }
                }
                n--;
            }
            if (isPalindrome) {
                temp = s.substring(start, last);
            }
            if (result.length() < temp.length()) {
                result = temp;
            }
        }
        return result;
    }

    static int resultStart;
    static int resultLength;
    
    public static void expandRange(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        int length = end - begin - 1;
        
        if (resultLength < length) {
            resultStart = begin + 1;
            resultLength = length;
        }
    }
    
    
    public static String longestPalindromebeta2(String s) {
        resultStart = 0;
        resultLength = 0;
        
        int strLength = s.length();
        
        if (strLength < 2) {
            return s;
        }
        for (int start = 0; start < strLength - 1; start++) {
            // odd
            expandRange(s, start, start);
            // even
            expandRange(s, start, start + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        String res = "";
        String[] str = new String[numRows];
        String temp = "";

        int longJump = (numRows - 1) * 2;

        for (int i = 0; i < s.length(); i += longJump) {
            temp += s.charAt(i);
        }
        str[0] = temp;

        temp = "";

        for (int i = numRows - 1; i < s.length(); i += longJump) {
            temp += s.charAt(i);
        }
        str[numRows - 1] = temp;

        for (int i = 1; i < numRows - 1; i++) {
            temp = "";

            int shortJump = (numRows - 1) * 2 - (i * 2);

            for (int j = i; j < s.length(); j += longJump) {
                temp += s.charAt(j);

                if (j + shortJump < s.length()) {
                    temp += s.charAt(j + shortJump);
                }
            }
            str[i] = temp;
        }

        for (int i = 0; i < numRows; i++) {
                res += str[i];
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 1));
        
        // System.out.println(longestPalindromebeta2(""));
        // System.out.println(longestPalindromebeta2("abb"));
        System.out.println(longestPalindromebeta2("bbc"));
        // System.out.println(longestPalindromebeta2("b"));
        // System.out.println(longestPalindromebeta2("bbccb"));
        System.out.println(longestPalindromebeta2("babad"));
        // System.out.println(longestPalindromebeta2("bbaabc"));
        // System.out.println(longestPalindromebeta2("bbaabb"));
        System.out.println(longestPalindromebeta2("bacabab"));
        // System.out.println(longestPalindromebeta2("xaabacxcabaaxcabaax"));
    }
}
