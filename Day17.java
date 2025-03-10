//93. Restore IP Addresses

class Solution {

    public boolean isValidStr(String str) {
        if (str.length() > 4 || str.charAt(0) == '0' && str.length() > 1) {
            return false;
        }

        int val = Integer.parseInt(str);
        return val >= 0 && val <= 255;
    }

    public void solve(String s, List<String> list, int count, String ans) {
        if (s.length() < 4 - count || s.length() > 3 * (4 - count)) {
            return;
        }

        if (count == 3) {
            if (isValidStr(s)) {
                list.add(ans + s);
            }
            return;
        }

        for (int i = 1; i <= 3 && i <= s.length(); i++) {  
            String part = s.substring(0, i);
            if (isValidStr(part)) {
                solve(s.substring(i), list, count + 1, ans + part + ".");
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return result;
        solve(s, result, 0, "");
        return result;
    }
}

