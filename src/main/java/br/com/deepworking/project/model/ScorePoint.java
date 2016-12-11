package br.com.deepworking.project.model;

import java.util.EnumSet;

public enum ScorePoint {

    GOOD(10),
    REGULAR(5),
    BAD(1);

    private int point;

    private ScorePoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public static ScorePoint fromInteger(Integer point) {
        return EnumSet.allOf(ScorePoint.class).stream()
                .filter((item) -> item.getPoint() == point)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid score point"));
    }
}
