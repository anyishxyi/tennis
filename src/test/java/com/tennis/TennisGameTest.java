package com.tennis;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameTest {
  @Test
  void score_initial() {
    TennisGame game = new TennisGame();
    assertEquals("Player A : 0 / Player B : 0", game.getScore());
  }

  @Test
  void playerA_scores() {
    TennisGame game = new TennisGame();
    game.pointWonBy('A');
    assertEquals("Player A : 15 / Player B : 0", game.getScore());
  }

  @Test
  void playerB_scores() {
    TennisGame game = new TennisGame();
    game.pointWonBy('B');
    assertEquals("Player A : 0 / Player B : 15", game.getScore());
  }

  @Test
  void playerA_scores_three_points() {
    TennisGame game = new TennisGame();
    game.pointWonBy('A');
    game.pointWonBy('A');
    game.pointWonBy('A');
    assertEquals("Player A : 40 / Player B : 0", game.getScore());
  }
}