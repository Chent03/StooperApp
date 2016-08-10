package com.cs6392016.gbergy.stooperapp;

/**
 * Created by Tony on 7/23/16.
 */
public class Item {

    private String Title;
    private String Category;
    private String Condition;
    private String Street;
    private String City;


    public Item(){

    }

    public Item(String Title, String Category, String Condition, String Street, String City){
        this.Title = Title;
        this.Category = Category;
        this.Condition = Condition;
        this.Street = Street;
        this.City = City;
    }
    public void setTitle(String title) {
        Title = title;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getCondition() {
        return Condition;
    }

    public String getStreet() {
        return Street;
    }

    public String getCity() {
        return City;
    }
}
