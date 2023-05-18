package com.example.dsa;
public class ReverseInteger {
static void reverseInteger(int n) {
     int a[] = new int[10];
     boolean isNegative = false;
     boolean isOverflow = false;
     if (n < 0) {
         isNegative = true;
         n = Math.abs(n);
     }
     int i = 0;
     int sum = 0;
     int prev = 0;
     while (n != 0) {
         a[i] = n % 10;
         n /= 10;
         sum = sum * 10 + a[i];
         if (sum < prev) {
             isOverflow = true;
             break;
         }
         prev = sum;
         i++;
     }
     if (isOverflow) {
         System.out.println(0);
     } else {
         if (isNegative) sum = -sum;
         System.out.println(sum);
     }
 }
 }
