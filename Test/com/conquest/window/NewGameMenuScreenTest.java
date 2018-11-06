package com.conquest.window;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.conquest.mapeditor.model.ContinentModel;
import com.conquest.mapeditor.model.MapHierarchyModel;
import com.conquest.utilities.Utility;

/**
 * The Class NewGameMenuScreenTest.
 */
public class NewGameMenuScreenTest {
	
	/** The utility. */
	private Utility utility = new Utility();
	
	/** The Asia map file path. */
	private static String asiaMapFilePath;
	
	/** The threemap filepath. */
	private static String threemapFilepath;
	
	/** The game window. */
	GameWindow gameWindow;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		asiaMapFilePath = System.getProperty("user.dir") + "\\resources\\testresource\\Asia.map";
		threemapFilepath= System.getProperty("user.dir") + "\\resources\\testresource\\three.map";
	}
	
	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * startup phase test.
	 */
	@Test
	public void checkValidationTest() {
		NewGameMenuScreen newgame=new NewGameMenuScreen();
		MapHierarchyModel mapHierarchyModel = utility.parseAndValidateMap(asiaMapFilePath);
		System.out.println(newgame.checkValidation(mapHierarchyModel,5));
		assertEquals("Passed",String.valueOf(newgame.checkValidation(mapHierarchyModel,5)));
	}
	
	/**
	 * startup phase test. test having 5 players and 4 countries.
	 */
	@Test
	public void checkValidation1Test() {
		NewGameMenuScreen newgame=new NewGameMenuScreen();
		MapHierarchyModel mapHierarchyModel = utility.parseAndValidateMap(threemapFilepath);
		System.out.println(newgame.checkValidation(mapHierarchyModel,5));
		System.out.println(mapHierarchyModel.errorMsg);
		assertEquals("Number of countries cannot be less than number of players",mapHierarchyModel.errorMsg);
	}

}
