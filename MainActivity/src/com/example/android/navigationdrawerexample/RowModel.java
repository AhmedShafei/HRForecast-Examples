package com.example.android.navigationdrawerexample;

public class RowModel {
	String name;
	 int value; /* 0 -&gt; checkbox disable, 1 -&gt; checkbox enable */
	 
	 RowModel(String name, int value){
	 this.name = name;
	 this.value = value;
	 }
	 public String getName(){
	 return this.name;
	 }
	 public int getValue(){
	 return this.value;
	 }
	 
}