package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/3 1:06
 * author: Garden Chan
 * description: LeetCode 165 比较版本号
 */
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] versionArr1 = version1.split("\\.");
        String[] versionArr2 = version2.split("\\.");
        for (int i = 0; i < versionArr1.length || i < versionArr2.length; i++) {
            int x = 0, y = 0;
            if (i <= versionArr1.length - 1) {
                x = Integer.parseInt(versionArr1[i]);
            }

            if (i <= versionArr2.length - 1) {
                y = Integer.parseInt(versionArr2[i]);
            }

            if (x < y) {
                return -1;
            }
            if (x > y) {
                return 1;
            }
        }
        return 0;
    }
}
