package com.sean.学习.贪心.ks;

/**
 * Article
 *
 * @author chenxu
 * @summary Article
 * @since 2020-08-07 15:13
 */
public class Article {

    public int weight;
    public int value;
    public double valueDensity;

    public Article(int weight, int value) {
        this.weight = weight;
        this.value = value;
        valueDensity = value * 1.0 / weight;
    }

    @Override
    public String toString() {
        return "Article [weight=" + weight + ", value=" + value + ", valueDensity=" + valueDensity + "]";
    }
}

