package com.tennis;

public class TennisGame {
  private int playerAScore = 0;
  private int playerBScore = 0;

  private static final int[] SCORE_TABLE = {0, 15, 30, 40};

  /**
   * Returns the current score of the game.
   */
  public String getScore() {
    return "Player A : " + SCORE_TABLE[playerAScore] + " / Player B : " + SCORE_TABLE[playerBScore];
  }

  /**
   * Called when a player wins a point.
   * @param player 'A' or 'B'
   */
  public void pointWonBy(char player) {
    if (player == 'A') {
      playerAScore++;
    } else if (player == 'B') {
      playerBScore++;
    }
  }
}