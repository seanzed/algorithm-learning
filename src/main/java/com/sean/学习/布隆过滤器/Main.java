package com.sean.学习.布隆过滤器;

/**
 * Main
 *
 * @author chenxu
 * @summary Main
 * @since 2020-08-10 21:07
 */
public class Main {

    public static void main(String[] args) {
		BloomFilter<Integer> bf = new BloomFilter<>(10_0000_0000, 0.01);
		for (int i = 1; i <= 1_00_0000; i++) {
			bf.put(i);
		}

		int count = 0;
		for (int i = 1_00_0001; i <= 2_00_0000; i++) {
			if (bf.contains(i)) {
				count++;
			}
		}
		System.out.println(count);

        // 数组
//        String[] urls = {};
//        BloomFilter<String> bf = new BloomFilter<String>(10_0000_0000, 0.01);
		/*
		for (String url : urls) {
			if (bf.contains(url)) continue;
			// 爬这个url
			// ......

			// 放进BloomFilter中
			bf.put(url);
		}*/

        /*for (String url : urls) {
            if (bf.put(url) == false) continue;
            // 爬这个url
            // ......
        }*/
    }

}
