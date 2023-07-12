package com.nebclass12organicchemistrynotes.app;

public class CategoryModel {

    private String subName;
    private int roundBack;
    private int verticalBack;
    private int textColor;

    public CategoryModel(String subName, int roundBack, int verticalBack, int textColor) {
        this.subName = subName;
        this.roundBack = roundBack;
        this.verticalBack = verticalBack;
        this.textColor = textColor;
    }

    public CategoryModel() {
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getRoundBack() {
        return roundBack;
    }

    public void setRoundBack(int roundBack) {
        this.roundBack = roundBack;
    }

    public int getVerticalBack() {
        return verticalBack;
    }

    public void setVerticalBack(int verticalBack) {
        this.verticalBack = verticalBack;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}
