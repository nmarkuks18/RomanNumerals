import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {

	@Test
	public void RomanIReturns1() {
		RomanNumerals nums = new RomanNumerals();
		assertEquals("Fail",1, nums.convertToInteger("I"));	
		
	}
	@Test
	public void RomanMReturns1000() {
		RomanNumerals nums = new RomanNumerals();
		assertEquals("Fail",1000, nums.convertToInteger("M"));	
		
	}
	@Test
	public void AddSymbolValuesTogether() {
		RomanNumerals nums = new RomanNumerals();
		assertEquals("Fail", 200, nums.convertToInteger("CC"));
	}
	@Test
	public void TestSubtractionCase() {
		RomanNumerals nums = new RomanNumerals();
		assertEquals("Fail", 4, nums.convertToInteger("IV"));
	}
	@Test
	public void TestLongCombinations() {
		RomanNumerals nums = new RomanNumerals();
		assertEquals("Fail", 1984, nums.convertToInteger("MCMLXXXIV"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void RepeatedLVDthrowsException() {
		RomanNumerals nums = new RomanNumerals();
		nums.convertToInteger("IVV");
	}
	@Test(expected=IllegalArgumentException.class)
	public void MoreThan3inARowthrowsException() {
		RomanNumerals nums = new RomanNumerals();
		nums.convertToInteger("MXXXXI");
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestInvalidSubtraction() {
		RomanNumerals nums = new RomanNumerals();
		nums.convertToInteger("XMD");	
	}
	@Test(expected=IllegalArgumentException.class)
	public void TwoSubtractionsPerNumeralThrowsException() {
		RomanNumerals nums = new RomanNumerals();
		nums.convertToInteger("CCM");	
	}
	@Test(expected=IllegalArgumentException.class)
	public void SubtractingLDorVThrowsException() {
		RomanNumerals nums = new RomanNumerals();
		nums.convertToInteger("DM");	
	}
	@Test(expected=IllegalArgumentException.class)
	public void NonRomaSymbolsThrowsException() {
		RomanNumerals nums = new RomanNumerals();
		nums.convertToInteger("X1V");
	}
	@Test
	public void TestFinishedProgramme() {
		RomanNumerals nums = new RomanNumerals();
		assertEquals("Fail", 2014, nums.convertToInteger("MMXIV"));
	}
	
}
