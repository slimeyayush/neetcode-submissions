class Solution {
    public int countSeniors(String[] details) {
        int seniors = 0;
        for(String str:details) {
            String age = str.substring(11,13);
            int check = Integer.parseInt(age);
            if(check > 60) {
                seniors++;
            }
        }
        return seniors;
    }
}