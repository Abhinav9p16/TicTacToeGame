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

	public static boolean checkWinner(char[] b, char ch) {
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe Game");
		board = createBoard();
		showBoard();
	}
}
