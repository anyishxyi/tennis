package com.tennis;

public class TennisGame {
  private int playerAScore = 0;
  private int playerBScore = 0;
  private boolean gameEnded = false;
  private String winner;

  private static final int[] SCORE_TABLE = {0, 15, 30, 40};

  /**
   * Returns the current score of the game or the winner of the game.
   */
  public String getScore() {
    if (gameEnded) return winner + " wins the game";

    return "Player A : " + SCORE_TABLE[playerAScore] + " / Player B : " + SCORE_TABLE[playerBScore];
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

    if (playerAScore >= 4 && playerAScore - playerBScore >= 2) {
      gameEnded = true;
      winner = "Player A";
    } else if (playerBScore >= 4 && playerBScore - playerAScore >= 2) {
      gameEnded = true;
      winner = "Player B";
    }
  }
}