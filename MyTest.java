package com.java.demo;

import java.util.List;
import java.util.function.Function;

public class MyTest implements Function<Integer, String>{

	@Override
	public String apply(Integer t) {
		return t.toString();
	}
	
	public Integer getPos(List<Integer> arr, Integer ele) {
		int i = -1;
		for(i=0;i<arr.size();i++) {
			if(arr.get(i).equals(ele)) {
				break;
			}
		}		
		return i;
	}
}
