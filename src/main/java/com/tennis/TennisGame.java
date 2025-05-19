package com.tennis;

public class TennisGame {
  private int playerAScore = 0;
  private int playerBScore = 0;
  private boolean gameEnded = false;
  private String winner = "";

  private static final int[] SCORE_TABLE = {0, 15, 30, 40};

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
      return (playerAScore - playerBScore) >= 2;
    }
    return false;
  }
}