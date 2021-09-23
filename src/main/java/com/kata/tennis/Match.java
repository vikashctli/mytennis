package com.kata.tennis;

public class Match {

	private static final Integer TWO = 2;
	private static final Integer THREE = 2;
	private Player player1;
	private Player player2;
	private Set currentSet;
	private Integer matchScorePlayer1;
	private Integer matchScorePlayer2;
	private Player winner;

	Match(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		matchScorePlayer1 = 0;
		matchScorePlayer2 = 0;
		currentSet = null;
	}

	void play(DisplayInformation displayInformation) {
		do {
			currentSet = new Set(this);
			currentSet.play(displayInformation);
			incrementMatchScorePlayer(currentSet.getWinner());
			announceWinner(displayInformation);
		} while (winner == null);

		// Display the Match Score
		displayInformation.displayMatchScore(getMatchScorePlayer1(), getMatchScorePlayer2());
	}

	void incrementMatchScorePlayer(Player player) {
		boolean player1Scoring = player.equals(player1);
		boolean player2Scoring = player.equals(player2);
		incrementMatchScore(player);

		// The first player to win 3 sets wins the Match
		if ((matchScorePlayer1.equals(THREE) && matchScorePlayer2 <= TWO && player1Scoring)
				|| (matchScorePlayer2.equals(THREE) && matchScorePlayer1 <= TWO && player2Scoring)) {
			designateWinner(player);
		}
	}

	private void incrementMatchScore(Player player) {
		if (player1.equals(player)) {
			matchScorePlayer1++;
		} else {
			matchScorePlayer2++;
		}
	}

	private void designateWinner(Player player) {
		winner = player1.equals(player) ? player1 : player2;
	}

	private void announceWinner(DisplayInformation displayInformation) {
		if (winner != null) {
			displayInformation.displayMatchWinner(winner);
		}
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Set getCurrentSet() {
		return currentSet;
	}

	public void setCurrentSet(Set currentSet) {
		this.currentSet = currentSet;
	}

	public Integer getMatchScorePlayer1() {
		return matchScorePlayer1;
	}

	public void setMatchScorePlayer1(Integer matchScorePlayer1) {
		this.matchScorePlayer1 = matchScorePlayer1;
	}

	public Integer getMatchScorePlayer2() {
		return matchScorePlayer2;
	}

	public void setMatchScorePlayer2(Integer matchScorePlayer2) {
		this.matchScorePlayer2 = matchScorePlayer2;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

}
