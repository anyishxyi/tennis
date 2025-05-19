package com.tennis;

import java.util.Scanner;

public class TennisGame {
  private int playerAScore = 0;
  private int playerBScore = 0;
  private boolean gameEnded = false;
  private String winner = "";

  private static final int[] SCORE_TABLE = {0, 15, 30, 40};

  /**
   * Entry point of the application.
   * Accepts a sequence of points won by players (e.g., "ABABAA") as a command-line argument
   * or via user input, then plays the game and prints the score after each point.
   *
   * @param args Optional argument representing the sequence of points.
   */
  public static void main(String[] args) {
    String input = "";

    if (args.length > 0) {
      input = args[0].toUpperCase();
    } else {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter the sequence of points (e.g. ABABAA): ");
      input = scanner.nextLine().trim().toUpperCase();
      scanner.close();
    }

    TennisGame game = new TennisGame();
    playGame(game, input, true);
  }

  /**
   * Plays a tennis game from a given input string.
   * Updates the game state according to the input.
   * If verbose is true, prints the score after each point.
   *
   * @param game    The TennisGame instance to update.
   * @param input   A string like "ABABAA", where 'A' and 'B' represent the players scoring.
   * @param verbose If true, prints the score after each point; otherwise, runs silently.
   */
  public static void playGame(TennisGame game, String input, boolean verbose) {
    for (char c : input.toCharArray()) {
      game.pointWonBy(c);
      if (verbose) {
        System.out.println(game.getScore());
      }
    }
  }

  /**
   * Returns the current score of the game or the winner of the game.
   */
  public String getScore() {
    if (gameEnded) return winner + " wins the game";

    if (playerAScore >= 3 && playerBScore >= 3) {
      if (playerAScore == playerBScore) return "Deuce";
      else if ((playerAScore - playerBScore) == 1) {
        return "Advantage " + ((playerAScore > playerBScore) ? "Player A" : "Player B");
      }
    }

    int scoreA = playerAScore >= 4 ? 40 : SCORE_TABLE[playerAScore];
    int scoreB = playerBScore >= 4 ? 40 : SCORE_TABLE[playerBScore];

    return "Player A : " + scoreA + " / Player B : " + scoreB;
  }

  /**
   * Called when a player wins a point.
   * @param player 'A' or 'B'
   */
  public void pointWonBy(char player) {
    if (gameEnded) return;

    if (player == 'A') {
      playerAScore++;
    } else if (player == 'B') {
      playerBScore++;
    }

    if (hasWinner()) {
      gameEnded = true;
      winner = (playerAScore > playerBScore) ? "Player A" : "Player B";
    }
  }

  /**
   * Returns true if the game has been won by one player.
   * A player must have at least 4 points and lead by 2.
   */
  private boolean hasWinner() {
    if (playerAScore >= 4 || playerBScore >= 4) {
      return Math.abs(playerAScore - playerBScore) >= 2;
    }
    return false;
  }
}