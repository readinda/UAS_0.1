package com.natania.uas_01.model;

import com.google.gson.annotations.SerializedName;


public class DessertItem {

	@SerializedName("strMealThumb")
	private String strMealThumb;

	@SerializedName("idMeal")
	private String idMeal;

	@SerializedName("strMeal")
	private String strMeal;

	public void setStrMealThumb(String strMealThumb){
		this.strMealThumb = strMealThumb;
	}

	public String getStrMealThumb(){
		return strMealThumb;
	}

	public void setIdMeal(String idMeal){
		this.idMeal = idMeal;
	}

	public String getIdMeal(){
		return idMeal;
	}

	public void setStrMeal(String strMeal){
		this.strMeal = strMeal;
	}

	public String getStrMeal(){
		return strMeal;
	}

	@Override
 	public String toString(){
		return 
			"DessertItem{" +
			"strMealThumb = '" + strMealThumb + '\'' + 
			",idMeal = '" + idMeal + '\'' + 
			",strMeal = '" + strMeal + '\'' + 
			"}";
		}
}