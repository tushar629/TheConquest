/**
 * 
 */
package com.conquest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.conquest.mapeditor.model.CountryModel;

/**
 * @author Rohit Gupta
 *
 */
public class CheaterPlayer implements Serializable, Strategy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.conquest.model.Strategy#reinforcementPhase(com.conquest.model.GameModel,
	 * com.conquest.model.PlayerModel)
	 */
	@Override
	public void reinforcementPhase(GameModel gameModel, PlayerModel playerModel) {
		// TODO Auto-generated method stub
		for (CountryModel countryModel : playerModel.getPlayerCountryList()) {
			int armies = countryModel.getNoOfArmiesCountry();
			armies = armies * 2;
			countryModel.setNoOfArmiesCountry(armies);
		}

		attackPhase(gameModel, playerModel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.conquest.model.Strategy#fortificationPhase(com.conquest.model.GameModel,
	 * com.conquest.model.PlayerModel)
	 */
	@Override
	public void fortificationPhase(GameModel gameModel, PlayerModel playerModel) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.conquest.model.Strategy#attackPhase(com.conquest.model.GameModel,
	 * com.conquest.model.PlayerModel)
	 */
	@Override
	public void attackPhase(GameModel gameModel, PlayerModel playerModel) {
		// TODO Auto-generated method stub
		List<CountryModel> countryList = new ArrayList<CountryModel>();
		for (CountryModel countryModel : playerModel.getPlayerCountryList()) {
			for (String countryName : countryModel.getListOfNeighbours()) {
				CountryModel country = gameModel.getMapHierarchyModel().searchCountry(countryName);
				countryList.add(country);
			}
		}
		for (CountryModel country : countryList)
			playerModel.addCountry(country);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.conquest.model.Strategy#assignInitialArmyToCountry(com.conquest.model.
	 * GameModel, com.conquest.model.PlayerModel)
	 */
	@Override
	public void assignInitialArmyToCountry(GameModel gameModel, PlayerModel playerModel) {
		// TODO Auto-generated method stub
		if (playerModel.getnoOfArmyInPlayer() > 0) {
			for (CountryModel countryModel : playerModel.getPlayerCountryList()) {
				countryModel.addNoOfArmiesCountry();

			}
			playerModel.reduceArmyInPlayer();
		}

	}
}
