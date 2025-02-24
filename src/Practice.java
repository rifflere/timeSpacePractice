import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Practice {

  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public static List<Integer> findEvens(int[] array) {
    List<Integer> evens = new ArrayList<>();
    for (int num : array) {
      if (num % 2 == 0) {
        evens.add(num);
      }
    }
    return evens;
  }

  // Time Complexity: O(n), where n = length of matrix
  // Space Complexity: O(1) 
  public static int sumDiagonal(int[][] matrix) {
    int sum = 0;
    for (int i = 0; i < matrix.length; i++) {
      sum += matrix[i][i];
    }
    return sum;
  }
  

  // Time Complexity: O(n)
  // Space Complexity: O(n)
  // Does the 'T' look confusing? Consider refreshing on generic methods
  // We'll revisit generics as a class later
  public static <T> Map<T, Integer> countFrequencies(T[] array) {
    HashMap<T, Integer> frequencies = new HashMap<>();
    for (T val : array) {
      frequencies.put(val, frequencies.getOrDefault(val, 0) + 1);
    }
    return frequencies;
  }

  /**
   * Returns the integer that shows up most frequently in an array.
   * If there is a tie, any one of the most common can be returned
   * arbitrarily.
   * 
   * THIS METHOD MUST RUN IN O(n) TIME. n = nums.size()
   * 
   * Once you finish, WRITE TESTS FOR IT in PracticeTest.java
   * 
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   * 
   * @param nums An array of integers
   * @return the integer that shows up most commonly
   */
  public static int mostCommonTimeEfficient(int[] nums) {
    // Complete this method with an implementation that runs
    // in O(n) time. n = nums.size()

    if (nums.length == 0){
      return 0;
    }

    Map<Integer, Integer> freq = new HashMap<>();

    for (Integer num : nums) {
      if (!freq.containsKey(num)) {
        freq.put(num, 1);
      } else {
        freq.put(num, freq.get(num) + 1);
      }
    }

    int highestVal = 0;
    int highestKey = nums[0];

    for (Integer key : freq.keySet()) {
      if (freq.get(key) > highestVal) {
        highestVal = freq.get(key);
        highestKey = key;
      }
    }
    return highestKey;
  }

  /**
   * Returns the integer that shows up most frequently in an array.
   * If there is a tie, any one of the most common can be returned
   * arbitrarily.
   * 
   * THIS METHOD MUST USE ONLY O(1) SPACE.
   * 
   * Once you finish, WRITE TESTS FOR IT in PracticeTest.java
   * 
   * Time Complexity: O(n^2)
   * Space Complexity: O(1)
   * 
   * @param nums An array of integers
   * @return the integer that shows up most commonly
   */
  public static int mostCommonSpaceEfficient(int[] nums) {
    // Complete this method with an implementation that runs
    // in O(1) space.
    if (nums.length == 0){
      return 0;
    }

    int mostFreqCount = 0;
    int mostFreqInt = nums[0];

    for (int i = 0; i < nums.length; i++) {
      int currentInt = nums[i];
      int freqCount = 0;

      for (int j = 1; j < nums.length; j++) {
        if (currentInt == nums[j]){
          freqCount++;
        }
      }

      if (freqCount > mostFreqCount){
        mostFreqCount = freqCount;
        mostFreqInt = currentInt;
      }
      
    }
    return mostFreqInt;
  }
}