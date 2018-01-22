 /**
 * Created by jianzhe on 2017/11/4.
 */
public class regressionExpression {
    private static boolean matching(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2] == true){
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else{
                    if (p.charAt(j - 1) == '*') {
                        if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                            dp[i][j] = dp[i][j - 2];
                        } else {
                            dp[i][j] = (dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j]);
                        }

                    }
                }
            }
        }
        return dp[s.length()][p.length()];

    }
    private static void main(String[] args) {

    }
}