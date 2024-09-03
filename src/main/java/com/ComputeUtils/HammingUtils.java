package com.ComputeUtils;

public class HammingUtils {

    /**
     * 输入两个simHash值，计算它们的海明距离
     * @param simHash1 原文文本的simHash值
     * @param simHash2 抄袭文本的simHash值
     * @return 两个simHash值之间的海明距离
     */
    public static int getHammingDistance(String simHash1, String simHash2) {
        int distance = 0; // 初始化海明距离
        if (simHash1.length() != simHash2.length()) {
            // 如果两个simHash的长度不一致，返回-1表示出错
            distance = -1;
        } else {
            for (int i = 0; i < simHash1.length(); i++) {
                // 遍历每一位，比较两者的字符是否相同
                if (simHash1.charAt(i) != simHash2.charAt(i)) {
                    distance++; // 如果不同，距离加1
                }
            }
        }
        System.out.println("海明距离为 " + distance); // 输出海明距离
        return distance; // 返回计算出的海明距离
    }

    /**
     * 输入两个simHash值，输出相似度
     * @param simHash1 原文文本的simHash值
     * @param simHash2 抄袭文本的simHash值
     * @return 两个simHash值之间的相似度（百分比）
     */
    public static double getSimilarity(String simHash1, String simHash2) {
        // 通过 simHash1 和 simHash2 获得它们的海明距离
        int distance = getHammingDistance(simHash1, simHash2);
        // 通过海明距离计算相似度（百分比形式），并返回
        return (100 - (double) (distance * 100) / 128);
    }

}
