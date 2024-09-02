package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlagiarismChecker {
    public Number checker(String string1,String string2) {
        List<String> list1 = participle(string1);
        List<String> list2 = participle(string2);

        Map<String, Integer> map1 = calculatedRate(list1);
        Map<String, Integer> map2 = calculatedRate(list2);

        double[] double1 = generateFeatureVector(map1);
        double[] double2 = generateFeatureVector(map2);

        long long1 = calculateSimhash(double1);
        long long2 = calculateSimhash(double2);

        int num = calculateHammingDistance(long1,long2);

        return Similar(num);
    }

    // 以空格与标点分词
    public List<String> participle(String text){
        return Arrays.asList(text.split("\\W+"));
    }

    // 计算词的出现频率
    public Map<String,Integer> calculatedRate(List<String> pars){
        Map<String,Integer> textMap = new HashMap<>();
        for(String par : pars){
            textMap.put(par,textMap.getOrDefault(par,0) + 1 );
        }

        return textMap;
    }

    // 生成特征向量
    public double[] generateFeatureVector(Map<String, Integer> frequencyMap) {
        double[] featureVector = new double[frequencyMap.size()];
        int index = 0;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            featureVector[index++] = entry.getValue();
        }
        return featureVector;
    }

    // 计算 Simhash 值
    public long calculateSimhash(double[] featureVector) {
        long hashValue = 0;
        for (int i = 0; i < featureVector.length; i++) {
            hashValue += (long) (featureVector[i] * (i + 1)) % 1000000007;
        }
        return hashValue;
    }

    // 比较 Simhash 值
    public int calculateHammingDistance(long hash1, long hash2) {
        return Long.bitCount(hash1 ^ hash2);
    }

     // 计算文本相似度
    public double Similar(int hammingDistance) {
        Double scale = (1 - hammingDistance / 64.0) * 100;

        return Double.parseDouble(String.format("%.2f", scale));
    }
}
