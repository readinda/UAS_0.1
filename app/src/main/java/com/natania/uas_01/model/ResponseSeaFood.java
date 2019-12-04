package com.natania.uas_01.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ResponseSeaFood{

	@SerializedName("meals")
	private List<SeafoodItem> meals;

	public void setMeals(List<SeafoodItem> meals){
		this.meals = meals;
	}

	public List<SeafoodItem> getMeals(){
		return meals;
	}

	@Override
 	public String toString(){
		return 
			"ResponseSeaFood{" + 
			"meals = '" + meals + '\'' + 
			"}";
		}
}