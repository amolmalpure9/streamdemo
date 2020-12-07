package com.java.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectDemo {

	public static void main(String[] args) {

		List<String> strList = Arrays.asList("Amol", "Priya", "Swapnil", "Yami");

		// prepare concurrent map from list
		ConcurrentMap<String, Integer> concMap = strList.stream()
				.collect(Collectors.toConcurrentMap(Function.identity(), o -> o.length()));

		// iterate map
		concMap.forEach((k, v) -> {
			System.out.println("Key :\t" + k + "\t val :\t" + v);
		});

		// join the string
		System.out.println(strList.stream().collect(Collectors.joining()));

		// count the strings
		System.out.println(strList.stream().collect(Collectors.counting()));

		// create arraylist based on the length of string
		strList.stream().map(o -> o.length()).collect(Collectors.toList()).forEach(o -> System.out.print(o + " "));

		System.out.println("\n-----------------------------------------------------------");

		// -------------------------------------------------------------------------------
		// Working with Integer streams
		List<Integer> intList = Arrays.asList(1, 64, 22, 5, 26, 42, 20, 6);

		// get min
		System.out.println(intList.stream().collect(Collectors.minBy(Comparator.naturalOrder())));

		// get max
		System.out.println(intList.stream().collect(Collectors.maxBy(Comparator.naturalOrder())));

		// group by length
		System.out.println(strList.stream().collect(Collectors.groupingBy(o -> o.length())));

		List<Integer> testList = Arrays.asList(1, 64, 22, 5, 26, 42, 20, 6);

		// create map in such a way that the index of the element in the list should be
		// key and value will be actual value in the list
		MyTest f = new MyTest();

		Map<Integer, String> testMap = testList.stream()
				.collect(Collectors.toMap(o -> f.getPos(testList, o), o -> o.toString()));

		// System.out.println(testMap);
		testMap.forEach((k, v) -> {
			System.out.println("Key :\t" + k + "\t val :\t" + v);
		});
	}

}
