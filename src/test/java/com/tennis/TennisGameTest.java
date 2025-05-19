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

  @Test
  void playerA_wins_game() {
    TennisGame game = new TennisGame();
    game.pointWonBy('A');
    game.pointWonBy('A');
    game.pointWonBy('A');
    game.pointWonBy('A');
    assertEquals("Player A wins the game", game.getScore());
  }

  @Test
  void score_is_deuce() {
    TennisGame game = new TennisGame();
    game.pointWonBy('A');
    game.pointWonBy('A');
    game.pointWonBy('A');

    game.pointWonBy('B');
    game.pointWonBy('B');
    game.pointWonBy('B');

    assertEquals("Deuce", game.getScore());
  }

  @Test
  void playerA_has_advantage() {
    TennisGame game = new TennisGame();
    game.pointWonBy('A');
    game.pointWonBy('A');
    game.pointWonBy('A');

    game.pointWonBy('B');
    game.pointWonBy('B');
    game.pointWonBy('B');

    game.pointWonBy('A'); // Advantage A after deuce

    assertEquals("Advantage Player A", game.getScore());
  }

  @Test
  void back_to_deuce_after_advantage() {
    TennisGame game = new TennisGame();
    game.pointWonBy('A');
    game.pointWonBy('A');
    game.pointWonBy('A');

    game.pointWonBy('B');
    game.pointWonBy('B');
    game.pointWonBy('B');

    game.pointWonBy('A'); // Adv A
    game.pointWonBy('B'); // back to deuce after advantage

    assertEquals("Deuce", game.getScore());
  }

  @Test
  void playerA_wins_after_advantage() {
    TennisGame game = new TennisGame();
    game.pointWonBy('A');
    game.pointWonBy('A');
    game.pointWonBy('A');

    game.pointWonBy('B');
    game.pointWonBy('B');
    game.pointWonBy('B');

    game.pointWonBy('A'); // Adv A
    game.pointWonBy('A'); // Win A

    assertEquals("Player A wins the game", game.getScore());
  }

  @Test
  void complete_sequence_ABABBB() {
    TennisGame game = new TennisGame();
    String input = "ABABBB";
    TennisGame.playGame(game, input, false);

    assertEquals("Player B wins the game", game.getScore());
  }

  @Test
  void complete_sequence_ABABAA() {
    TennisGame game = new TennisGame();
    String input = "ABABAA";
    TennisGame.playGame(game, input, false);

    assertEquals("Player A wins the game", game.getScore());
  }
}