class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            int n = str.length();
            sb.append(n + "#" + str);
        }
        System.out.println(sb);
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        
        int n = str.length();
        int i = 0;
        while(i < n) {
            StringBuilder sb = new StringBuilder();
            int j = i;
            while(j < n && str.charAt(j) != '#') {
                sb.append(str.charAt(j));
                j++;
            }
            String numS = sb.toString();
            int len = Integer.parseInt(numS);
            int encodeSectionLength = numS.length() + 1;
            String s = str.substring(i + encodeSectionLength, i + encodeSectionLength + len);

            res.add(s);
            i = i + encodeSectionLength + len;
        }

        return res;
    }
}
