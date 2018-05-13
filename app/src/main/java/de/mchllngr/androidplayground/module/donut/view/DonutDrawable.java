package de.mchllngr.androidplayground.module.donut.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * Custom drawn Donut as seen here https://www.youtube.com/watch?v=H05mF0qrBVA (https://github.com/rharter/mmmmm)
 */
public class DonutDrawable extends Drawable {

    private final Path holePath = new Path();

    private final Paint donutPaint = new Paint();
    private final Paint icingPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint sprinklePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private final List<Sprinkle> sprinkles = Sprinkle.generateRandomSprinkles(100);

    public DonutDrawable() {
        donutPaint.setColor(0xFFC6853B);

        icingPaint.setColor(0xFF441111);
        icingPaint.setPathEffect(new ComposePathEffect(
                new CornerPathEffect(40f),
                new DiscretePathEffect(60f, 25f)
        ));
    }

    private int getDonutSize(@NonNull Rect bounds) {
        return Math.min(bounds.width(), bounds.height());
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        if (bounds == null) return;

        // get holepath for bounds
        holePath.reset();
        holePath.addCircle(
                bounds.exactCenterX(),
                bounds.exactCenterY(),
                getDonutSize(bounds) / 6f,
                Path.Direction.CW
        );
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        float cx = bounds.exactCenterX();
        float cy = bounds.exactCenterY();
        int s = getDonutSize(bounds);

        canvas.save();

        // draw donut with hole
        canvas.clipPath(holePath, Region.Op.DIFFERENCE);
        canvas.drawCircle(
                cx,
                cy,
                s / 2f,
                donutPaint
        );

        // draw icing
        canvas.drawCircle(
                cx,
                cy,
                s / 2.2f,
                icingPaint
        );

        // draw sprinkles
        for (Sprinkle sprinkle : sprinkles) {
            float holeRadius = s / 6f;
            float padding = 20f;
            float ringRadius = s / 3f;
            float modDistance = holeRadius + padding + (ringRadius - padding * 2) * sprinkle.distance;

            canvas.save();

            // transform canvas for easier sprinkle drawing
            canvas.rotate(sprinkle.angle, cx, cy); // rotate the entire canvas around the center
            canvas.translate(0f, modDistance); // move the canvas to the sprinkle's position
            canvas.rotate(sprinkle.rotation + 360f * sprinkle.rotation, cx, cy); // rotate the canvas around the sprinkle's location

            sprinklePaint.setColor(sprinkle.color);
            canvas.drawRoundRect(
                    new RectF(
                            cx - 7f,
                            cy - 22f,
                            cx + 7f,
                            cy + 22f),
                    10f,
                    10f,
                    sprinklePaint
            );

            canvas.restore();
        }

        canvas.restore();
    }

    @Override
    public void setAlpha(int alpha) {
        throw new IllegalStateException("Who wants an invisible donut?");
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        throw new IllegalStateException("Who cares about color filters?");
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
