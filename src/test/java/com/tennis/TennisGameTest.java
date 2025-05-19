package com.tennis;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameTest {
  @Test
  void score_initial() {
    TennisGame game = new TennisGame();
    assertEquals("Player A : 0 / Player B : 0", game.getScore());
  }
}