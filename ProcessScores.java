import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

import java.text.DecimalFormat;

import java.util.Arrays;

import java.util.HashMap;

import java.util.Map;

public class ProcessScores {

public static void main(String[] args) {

int numOfLines = 0;

/*

* using try with resources, introduced in java 7, so as we do not need

* to worry about closing resources.

*/

try (BufferedReader br = new BufferedReader(new FileReader(new File("afl.txt")))) {

/*

* reading number of lines in the file.

*/

while (br.readLine() != null) {

numOfLines++;

}

} catch (FileNotFoundException e) {

// TODO Auto-generated catch block

e.printStackTrace();

} catch (IOException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}

/*

* creating array of length numOfLines.

*/

int[] scoresArr = new int[numOfLines];

/*

* again reading and scoring in our scores array

*/

try (BufferedReader br = new BufferedReader(new FileReader(new File("afl.txt")))) {

String line = "";

int i = 0;

while ((line = br.readLine()) != null) {

scoresArr[i] = Integer.parseInt(line);

i++;

}

} catch (FileNotFoundException e) {

// TODO Auto-generated catch block

e.printStackTrace();

} catch (IOException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}

System.out.println("Maximum Score is: " + highest(scoresArr));

System.out.println("Lowest Score is: " + lowest(scoresArr));

System.out.println("Average Score is: " + average(scoresArr));

System.out.println("Range of score is: " + (highest(scoresArr) - lowest(scoresArr)));

/*

* passing clone of array, in order to preserve the original array

*/

System.out.println("Median of score is: " + median(scoresArr.clone()));

System.out.println("Mode of scores is: " + mode(scoresArr));

}

// Return the maximum value of the given int[]

public static int highest(int[] array) {

// int max = array[0]; // Assume that max is the first element

// From second element, if the element is more than max, set the max to

// this element.

int max = array[0];

for (int i = 1; i < array.length; i++) {

if (array[i] > max) {

max = array[i];

}

}

return max;

}

// Return the minimum value of the given int[]

public static int lowest(int[] array) {

int min = array[0];

for (int i = 1; i < array.length; i++) {

if (array[i] < min) {

min = array[i];

}

}

return min;

}

// Return the median value of the given int[]

// Median is the center element for odd-number array,

// or average of the two center elements for even-number array.

// Use Arrays.sort(anArray) to sort anArray in place.

public static double median(int[] array) {

/*

* using Arrays.sort to sort the number

*/

Arrays.sort(array);

/*

* using decimal format to format the number to two decimal places

*/

DecimalFormat df = new DecimalFormat("##.##");

/*

* if length of array is a even number, median is the average of two

* middle numbers, else if length is odd number, median is the middle

* number

*/

if (array.length % 2 == 0) {

int index = array.length / 2;

double sum = array[index] + array[index - 1];

return Double.parseDouble(df.format(sum / 2));

} else {

return Double.parseDouble(df.format(array.length / 2));

}

}

// Return the average value of the given int[]

public static double average(int[] array) {

DecimalFormat df = new DecimalFormat("##.##");

double average = 0;

double sum = 0.0;

for (int i = 0; i < array.length; i++) {

sum = sum + array[i];

}

average = sum / array.length;

average = Double.parseDouble(df.format(average));

return average;

}

private static int mode(int[] scoresArr) {

Map<Integer, Integer> scoresMap = new HashMap<>();

/*

* inserting values into hashMap, key of map is score, if same key is found

* we increment the value corresponding to that key by 1,

*/

for (Integer score : scoresArr) {

if (scoresMap.containsKey(score)) {

scoresMap.put(score, scoresMap.get(score) + 1);

} else {

scoresMap.put(score, 1);

}

}

int maxValue = 0;

int keyOfMaxOccurence = 0;

/*

* Now we iterate map, and the key with highest value, will be the mode

*/

for(Map.Entry<Integer, Integer> entry : scoresMap.entrySet()) {

int key = entry.getKey();

int value = entry.getValue();

if(value > maxValue) {

maxValue = value;

keyOfMaxOccurence = key;

}

}

return keyOfMaxOccurence;

}

}