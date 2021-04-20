package com.hukam.wordcount;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hukam.subsetsum.logic.SubsetSumLogic;

public class SubsetSumLogicTest {

	SubsetSumLogic subsetLogic = new SubsetSumLogic();

	@Test
	public void testSumlogic1() {
		String output = subsetLogic.processInput("{2, 3, 5, 6, 8, 10}", 10);
		assertTrue(output.equals("<br />5  3  2<br />8  2<br />10"));
	}
	
	@Test
	public void testSumlogic2() {
		String output = subsetLogic.processInput("1, 2, 3, 4, 5", 10);
		assertTrue(output.equals("<br />4  3  2  1<br />5  3  2<br />5  4  1"));
	}

}
