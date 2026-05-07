import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {

            // Add current fruit
            map.put(fruits[right],
                    map.getOrDefault(fruits[right], 0) + 1);

            // If more than 2 fruit types, shrink window
            while (map.size() > 2) {

                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            // Update answer
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}