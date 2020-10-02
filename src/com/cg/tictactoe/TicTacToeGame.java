package com.cg.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	static char[] board = new char[10];
	static Scanner sc = new Scanner(System.in);

	private static char[] createBoard() {
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

	private static char inputPlayer() {
		char choice = Character.toUpperCase(sc.next().charAt(0));
		if (choice == 'X' || choice == 'O')
			return choice;
		else
			System.out.println("Invalid Choice");
		return inputPlayer();

	}

	private static void showBoard() {
		System.out.println("*************");
		System.out.println("|" + board[1] + "  |  " + board[2] + " |  " + board[3] + " |");
		System.out.println("|-------------|");
		System.out.println("|" + board[4] + "  |  " + board[5] + " |  " + board[6] + " |");
		System.out.println("|-------------|");
		System.out.println("|" + board[7] + "  |  " + board[8] + " |  " + board[9] + " |");
		System.out.println("*************");
	}

	private static boolean userMove(char user) {
		System.out.println("Where to place the user");
		int index = sc.nextInt();
		if (board[index] == ' ') {
			board[index] = user;
			return checkWinner(board, user);
		} else
			System.out.println("Index is occupied");
		return userMove(user);
	}
	private static int potentialWinner(char ch) {
	     if(board[1] == ch && board[2] == ch && board[3] == ' ') return 3;
	else if(board[1] == ch && board[3] == ch && board[2] == ' ') return 2;
	else if(board[2] == ch && board[3] == ch && board[1] == ' ') return 1;
	else if(board[4] == ch && board[5] == ch && board[6] == ' ') return 6;
	else if(board[4] == ch && board[6] == ch && board[5] == ' ') return 5;
	else if(board[6] == ch && board[5] == ch && board[4] == ' ') return 4;
	else if(board[7] == ch && board[8] == ch && board[9] == ' ') return 9;
	else if(board[7] == ch && board[9] == ch && board[8] == ' ') return 8;
	else if(board[8] == ch && board[9] == ch && board[7] == ' ') return 7;

	else if(board[1] == ch && board[4] == ch && board[7] == ' ') return 7;
	else if(board[1] == ch && board[7] == ch && board[4] == ' ') return 4;
	else if(board[7] == ch && board[4] == ch && board[1] == ' ') return 1;
	else if(board[5] == ch && board[8] == ch && board[2] == ' ') return 2;
	else if(board[5] == ch && board[2] == ch && board[8] == ' ') return 8;
	else if(board[8] == ch && board[2] == ch && board[5] == ' ') return 5;
	else if(board[3] == ch && board[6] == ch && board[9] == ' ') return 9;
	else if(board[3] == ch && board[9] == ch && board[6] == ' ') return 6;
	else if(board[6] == ch && board[9] == ch && board[3] == ' ') return 3;

	else if(board[1] == ch && board[5] == ch && board[9] == ' ') return 9;
	else if(board[1] == ch && board[9] == ch && board[5] == ' ') return 5;
	else if(board[5] == ch && board[9] == ch && board[1] == ' ') return 1;

	else if(board[3] == ch && board[5] == ch && board[7] == ' ') return 7;
	else if(board[7] == ch && board[5] == ch && board[3] == ' ') return 3;
	else if(board[7] == ch && board[3] == ch && board[5] == ' ') return 5;
	return 0 ;
}
	private static int getBestNextMove(char pc, char user) {
		int index= potentialWinner(pc);  
		if(index == 0) 
			index = potentialWinner(user);    
		if(index ==0)
		{  if(board[1]==' ') return 1;
		   else if(board[3]==' ') return 3;
		   else if(board[7]==' ') return 7;
		   else if(board[9]==' ') return 9;
		   else if(board[5]==' ') return 5;
		}
	    
	    return index;
	}

	private static boolean pcMove(char pc,char user) {

		int index = getBestNextMove(pc, user);
		if (index == 0)	
			return false;
		board[index] = pc;
		return checkWinner(board,pc);
	}
	public static boolean checkWinner(char[] b, char ch) {
		return ((b[1] == ch && b[2] == ch && b[3] == ch) || (b[4] == ch && b[5] == ch && b[6] == ch)
				|| (b[7] == ch && b[8] == ch && b[9] == ch) || (b[1] == ch && b[4] == ch && b[7] == ch)
				|| (b[2] == ch && b[5] == ch && b[8] == ch) || (b[3] == ch && b[6] == ch && b[9] == ch)
				|| (b[1] == ch && b[5] == ch && b[9] == ch) || (b[3] == ch && b[5] == ch && b[7] == ch));
	}
    
	public static int tossUp() {
		int toss = (int) Math.floor(Math.random() * 2);
		return toss;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe Game");
		board = createBoard();
		showBoard();
		System.out.println("Choose bw X/O");
		char user = inputPlayer();
		char pc = (user == 'X') ? 'O' : 'X';
		System.out.println("User has " + user + " &  PC has " + pc);
		int chose = tossUp(); 
		int i;
		for (i = 0; i < 9; ++i, chose++) { 
			if (chose % 2 == 0) {
				System.out.println("user turn");
				if (userMove(user)) {
					System.out.println("User jeeta");
					break; 
				}
			} else {
				System.out.println("pc turn");
				if (pcMove(pc,user)) {
					System.out.println("pc jeeta");
					break;
				}
			}
			showBoard();
		} 
			
		 

		if (i == 9) {
			System.out.println("Its a tie");
		} else
			showBoard();
	}
}
