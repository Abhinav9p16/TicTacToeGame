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

	
	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe Game");
		board = createBoard();
	}
}
