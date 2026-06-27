class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> ana = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
        int[] freq = new int[26];

        for (char c : strs[i].toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder keyBuilder = new StringBuilder();
        for (int j = 0; j < 26; j++) {
            keyBuilder.append(freq[j]).append('#');
        }

        String key = keyBuilder.toString();

        ana.computeIfAbsent(key, k -> new ArrayList<>())
           .add(strs[i]);
    }

    return new ArrayList<>(ana.values());
}

}
