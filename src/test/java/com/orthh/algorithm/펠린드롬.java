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

    }

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






}
