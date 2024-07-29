package com.orthh.algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Palindrome Algorithm
 * leetCode
 * https://leetcode.com/problems/valid-palindrome/
 *
 */
@DisplayName("펠린드롬 알고리즘")
public class 펠린드롬 {

    @DisplayName("isLetterOrDigitTest")
    @Test
    public void isLetterOrDigitTest(){
        String s = "Do geese see God?";
        assertEquals('G', s.charAt(13) );
        assertEquals('g', Character.toLowerCase(s.charAt(13)));
        assertTrue(Character.isLetterOrDigit('G'));
    }

    @DisplayName("펠린드롬 알고리즘 실행")
    @Test
    public void solution(){
        String testCase_1 = "Do geese see God?";
        String testCase_2 = "A man, a plan, a canal: Panama";
        String testCase_3 = "race a car";
        assertTrue(isPalindrome(testCase_1));
        assertTrue(isPalindrome(testCase_2));
        assertFalse(isPalindrome(testCase_3));

        assertTrue(isPalindromeSimple(testCase_1));
        assertTrue(isPalindromeSimple(testCase_2));
        assertFalse(isPalindromeSimple(testCase_3));

    }

    @DisplayName("2번안 - 정규식으로 영숫자 걸러내는 테스트")
    @Test
    public void regex(){
        String testCase_1 = "Do geese see God?";
        String testCase_2 = "A man, a plan, a canal: Panama";

        assertEquals(testCase_1.replaceAll("[^A-Za-z0-9]",""), "DogeeseseeGod");
        assertEquals(testCase_1.replaceAll("[^A-Za-z0-9]","").toLowerCase(), "dogeeseseegod");

    }


    // 1번안
    private boolean isPalindrome(String s) {
        int startPointer = 0;
        int endPointer = s.length() - 1;

        while(startPointer < endPointer){
            if(!Character.isLetterOrDigit(s.charAt(startPointer))){
                startPointer++;
            }else if(!Character.isLetterOrDigit(s.charAt(endPointer))){
                endPointer--;
            }else {
                if(Character.toLowerCase(s.charAt(startPointer)) != Character.toLowerCase(s.charAt(endPointer))){
                    return false;
                }
                startPointer++;
                endPointer--;
            }
        }
        return true;
    }

    // 2번안 - 간결하게 표현 가능하나, 정규식을 사용하고, 원시 자료형인 char 로 비교하는 방식에 비해 느림.
    private boolean isPalindromeSimple(String s){
        String s_filterd = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        String s_reversed = new StringBuilder(s.replaceAll("[^A-Za-z0-9]","").toLowerCase()).reverse().toString();
        return s_filterd.equals(s_reversed);
    }

}
