public class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26]; // frequency array
        int left = 0, maxFreq = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // increase frequency
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // check if window is valid
            if ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}