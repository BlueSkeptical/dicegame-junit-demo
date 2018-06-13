package com.game.dice.code;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.DiceGame;

public class DiceGameTest {
	static DiceGame testGame;
	 private final static String WIN = "Great you won :)...!!";
	    private final static String LOS = "I am sorry you lost :(...!!";
	    private final static String TIE = "Not bad, its a tie...!!";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("TestDiceGame.setUpBeforeClass()");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("TestDiceGame.tearDownAfterClass()");
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testDrawDicesNegative() {
		boolean myResult = false;
		testGame = new DiceGame();
		List<Integer> diceList = testGame.drawDices();
		for(int i=0; i < diceList.size(); i++){
			if(diceList.get(i) > 6)
				myResult = true;
		}
		Assert.assertFalse(myResult);
	}
	
	@Test
	public void testDrawDicesPositive() {
		boolean myResult = false;
		testGame = new DiceGame();
		List<Integer> diceList = testGame.drawDices();
		for(int i=0; i < diceList.size(); i++){
			if(diceList.get(i) <= 6)
				myResult = true;
		}
		Assert.assertTrue(myResult);
	}
	
	@Test
	public void testAddDicePositive() {
		testGame = new DiceGame();
		int i= 10;
		int j=20;
		int result = i+j;
		List<Integer> diceList = new ArrayList<>();
		diceList.add(i);
		diceList.add(j);
		
		int myResult = testGame.addDice(diceList);
		Assert.assertEquals(result, myResult);
	}
	
	@Test
	public void testAddDiceNegative() {
		testGame = new DiceGame();
		int i= 10;
		int j=20;
		int result = i+j;
		List<Integer> diceList = new ArrayList<>();
		diceList.add(i);
		diceList.add(j);
		
		int myResult = testGame.addDice(diceList);
		Assert.assertNotEquals(result, myResult+i);
	}
	
	
	@Test
	public void testRolTheDice() {
		testGame = new DiceGame();
		List<List<Integer>> myList = testGame.rollTheDice();
		
		Assert.assertNotNull(myList);
	}
	
	@Test
	public void testFunctionality() {
		testGame = new DiceGame();
		String myWinner;
		
		List<List<Integer>> myList = testGame.rollTheDice();
		int result1 = testGame.addDice(myList.get(0));
		int result2 = testGame.addDice(myList.get(1));
		if(result1 > result2){
			myWinner=WIN;
			testGame.setScore(0, result1);
		}else if (result1 < result2){
			myWinner=LOS;
			testGame.setScore(1, result2);
		}else{
			myWinner=TIE;
		}
		//testGame.getScore(playerIndex)
		Assert.assertNotNull(myWinner);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDiceStringNegative() {
		testGame = new DiceGame();
		String myResult = testGame.getDiceString(9);
		
	}
}
