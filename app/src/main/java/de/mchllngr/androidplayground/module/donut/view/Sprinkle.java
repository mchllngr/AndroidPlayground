package de.mchllngr.androidplayground.module.donut.view;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Sprinkle {

    private static final int[] SPRINKLE_COLORS = new int[]{Color.RED, Color.WHITE, Color.YELLOW, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA};

    final int color;
    final float angle;
    final float distance;
    final float rotation;

    private Sprinkle(int color, float angle, float distance, float rotation) {
        this.color = color;
        this.angle = angle;
        this.distance = distance;
        this.rotation = rotation;
    }

    static List<Sprinkle> generateRandomSprinkles(int count) {
        Random random = new Random();
        ArrayList<Sprinkle> sprinkles = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            sprinkles.add(new Sprinkle(
                    SPRINKLE_COLORS[i % SPRINKLE_COLORS.length],
                    random.nextFloat() * 360f,
                    random.nextFloat(),
                    random.nextFloat() * 360f
            ));
        }

        return sprinkles;
    }
}
