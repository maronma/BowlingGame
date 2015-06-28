import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameCalculatorTest {
private BowlingGameResultCalculator calc;
	@Before
	public void setCalc(){
		 calc = new BowlingGameResultCaluclatorImpl();
	}
	 public void valueOfRollAndNumbersOfPin(int valueOfRoll, int numberOfPins) {
		    for (int i = 0; i < valueOfRoll; i++)
		      calc.roll(numberOfPins);
		  }
	  public void onlyStrikeInGame(int valueOfRoll, int numberOfPins){
		  for (int i = 1; i <= (valueOfRoll+10); i++) {
			  if((i%2 != 0)==true){calc.roll(0); continue;}else{ calc.roll(numberOfPins);}
	  }}
	 
	@Test
	public void shouldReturn1ForPin1() {
		// given
		int pins = 1;
		// when
		calc.roll(pins);
		int score = calc.score();
		// then
		Assert.assertEquals(1, score);
	}

	@Test
	public void shouldReturn5ForPin5() {
		// given
		int pins = 5;
		// when
		calc.roll(pins);
		int score = calc.score();
		// then
		Assert.assertEquals(5, score);
	}
	
	@Test
	public void shouldReturn6ForPin5Pin1() {
		// given
		// when
		calc.roll(5);
		calc.roll(1);
		int score = calc.score();
		// then
		Assert.assertEquals(6, score);
	}
	@Test
	public void shouldReturn12ForPin8Pin2Pin1() {
		// given
		// when
		calc.roll(8);
		calc.roll(2);
		calc.roll(1);
		int score = calc.score();
		// then
		Assert.assertEquals(12, score);
	}
	@Test
	public void shouldReturn16ForPin1Pin8Pin2Pin5() {
		// given
		// when
		calc.roll(1);
		calc.roll(8);
		calc.roll(2);
		calc.roll(5);
		int score = calc.score();
		// then
		Assert.assertEquals(16, score);
	}
	
	@Test
	public void shouldReturn26ForPin8Pin2Pin5Pin5Pin1() {
		// given
		// when
		calc.roll(8);
		calc.roll(2);
		calc.roll(5);
		calc.roll(5);
		calc.roll(1);
		int score = calc.score();
		// then
		Assert.assertEquals(27, score);
	}
	@Test
	public void shouldReturn36ForPin10Pin9Pin1Pin3() {
		// given
		// when
		calc.roll(10);
		calc.roll(9);
		calc.roll(1);
		calc.roll(3);
		int score = calc.score();
		// then
		Assert.assertEquals(36, score);
	}
	@Test
	public void shouldReturn300ForPin12x10() {
		// given
		// when
		valueOfRollAndNumbersOfPin(12, 10);
		int score = calc.score();
		// then
		Assert.assertEquals(300, score);
	}
	@Test
	public void shouldReturn18ForPin10Pin2Pin2() {
		// given
		// when
		calc.roll(10);
		calc.roll(2);
		calc.roll(2);
		
		int score = calc.score();
		// then
		Assert.assertEquals(18, score);
	}
	@Test
	public void shouldReturn27ForPin5Pin5Pin5Pin5Pin1() {
		// given
		// when
		calc.roll(5);
		calc.roll(5);
		calc.roll(5);
		calc.roll(5);
		calc.roll(1);
		int score = calc.score();
		// then
		Assert.assertEquals(27, score);
	}
	@Test
	public void shouldReturn73ForPin10Pin10Pin10Pin3Pin2() {
		// given
		// when
		calc.roll(10);
		calc.roll(10);
		calc.roll(10);
		calc.roll(3);
		calc.roll(2);
		int score = calc.score();
		// then
		Assert.assertEquals(73, score);
	}
	
	@Test
	public void shouldReturn150ForPin5x21() {
		// given
		// when
		
		valueOfRollAndNumbersOfPin(21, 5);
		
		int score = calc.score();
		// then
		Assert.assertEquals(150, score);
	}
	 
	  @Test
		public void shouldReturn0ForPin0x20() {
			// given
			// when
			valueOfRollAndNumbersOfPin(20, 0);
			
			int score = calc.score();
			// then
			Assert.assertEquals(0, score);
		}
	  @Test
		public void shouldReturn40ForPin2x20() {
			// given
			// when
			valueOfRollAndNumbersOfPin(20, 2);
			
			int score = calc.score();
			// then
			Assert.assertEquals(40, score);
		}
	  @Test
		public void shouldReturn100ForPin10x10() {
			// given
			// when
			onlyStrikeInGame(10, 10);
			int score = calc.score();
			// then
			Assert.assertEquals(100, score);
		}


}
