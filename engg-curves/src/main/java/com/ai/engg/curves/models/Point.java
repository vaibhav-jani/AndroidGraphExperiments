/**
 * Simple graph point
 */
package com.ai.engg.curves.models;

public class Point {

    public float x;
    public float y;

    public Point(float x, float y) {

        this.x = x;
        this.y = y;
    }

    public Point(Point p) {

        this.x = p.x;
        this.y = p.y;
    }
}
