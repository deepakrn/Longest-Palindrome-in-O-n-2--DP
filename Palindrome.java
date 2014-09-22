package DP;

import java.util.Scanner;

public class Palindrome {
public static void main(String args[]){
	Scanner in = new Scanner(System.in);	
	String s=in.next();
	
	int n=s.length();
	int[][] table = new int[n+1][n+1];
	for(int i=0; i<=n; i++){
		for(int j=i; j<=n; j++){
			if(i==j-1 && i>0 && j>0){
				if(s.charAt(i-1)==s.charAt(j-1))
					table[i][j]=2;
					continue;
			}
			if(j==0||i==0)
				table[i][j]=0;
			else if(i==j)
				table[i][i]=1;
			else
				table[i][j]=0;			
		}
	}

	for(int size=2; size<n; size++){
		for(int i=1; i<n-size+1; i++){
			int j=i+size;
			if(s.charAt(i-1)==s.charAt(j-1) && table[i+1][j-1]>0)
			table[i][j]+=table[i+1][j-1]+2;
		}
	}
	for(int i=1; i<=n; i++){
		for(int j=1; j<=n; j++){
			System.out.print(table[i][j]+ " ");
		}
		System.out.println("");
	}
}
}
