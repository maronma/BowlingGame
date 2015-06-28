public class BowlingGameResultCaluclatorImpl implements
		BowlingGameResultCalculator {

	// private int mPreviousPins;
	// private int mActualScore;
	// private boolean mSpare;
	// private int mCount = 0;
	// private int mCount1 = 0;
	int rolls[] = new int[21];
	int currentRound = 0;

	@Override
	public void roll(int numberOfPins) {
		rolls[currentRound++] = numberOfPins;

	}

	@Override
	public int score() {
		// return mActualScore;
		int score = 0;
		int singleThrow = 0;
		for (int roundInGame = 0; roundInGame < 10; roundInGame++) {
			if (isStrikeBonus(singleThrow)) {
				score += 10 + givePointsForstrikeBonus(singleThrow);
				singleThrow++;
			} else if (isSpareBonus(singleThrow)) {
				score += 10 + givePointsForSpareBonus(singleThrow);
				singleThrow += 2;
			} else {
				score += sumOfBallsInGameWithoutBonus(singleThrow);
				singleThrow += 2;
			}
		}
		return score;
	}

	boolean isSpareBonus(int singleThrow) {
		return rolls[singleThrow] + rolls[singleThrow + 1] == 10;
	}

	boolean isStrikeBonus(int singleThrow) {
		return rolls[singleThrow] == 10;
	}

	int givePointsForSpareBonus(int singleThrow) {
		return rolls[singleThrow + 2];
	}

	int givePointsForstrikeBonus(int singleThrow) {
		return rolls[singleThrow + 1] + rolls[singleThrow + 2];
	}

	int sumOfBallsInGameWithoutBonus(int singleThrow) {
		return rolls[singleThrow] + rolls[singleThrow + 1];
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
