package com.natania.uas_01.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResponseDessert{

	@SerializedName("meals")
	private List<DessertItem> meals;

	public void setMeals(List<DessertItem> meals){
		this.meals = meals;
	}

	public List<DessertItem> getMeals(){
		return meals;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDessert{" + 
			"meals = '" + meals + '\'' + 
			"}";
		}
}