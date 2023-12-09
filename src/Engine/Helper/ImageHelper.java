package Engine.Helper;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * Helper class for image processing.
 */
public class ImageHelper {
    /**
     * Rotate an image counter clock-wise.
     *
     * @param i      The target image.
     * @param degree The angle to rotate.
     * @return The processed image.
     */
    public static Image rotateCCW(Image i, double degree) {
        BufferedImage bi = (BufferedImage) i;
        AffineTransform tx = new AffineTransform();
        tx.rotate((degree / 180) * Math.PI, (double) bi.getWidth() / 2, (double) bi.getHeight() / 2);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(bi, null);
    }

    /**
     * Rotate an image clock-wise.
     *
     * @param i      The target image.
     * @param degree The angle to rotate.
     * @return The processed image.
     */
    public static Image rotateCW(Image i, double degree) {
        BufferedImage bi = (BufferedImage) i;
        AffineTransform tx = new AffineTransform();
        tx.rotate(-(degree / 180) * Math.PI, (double) bi.getWidth() / 2, (double) bi.getHeight() / 2);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(bi, null);
    }

    /**
     * Flip an image horizontally.
     *
     * @param i The target image.
     * @return The processed image.
     */
    public static Image flipHorizontal(Image i) {
        BufferedImage bi = (BufferedImage) i;
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-i.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(bi, null);
    }

    /**
     * Flip an image vertically.
     *
     * @param i The target image.
     * @return The processed image.
     */
    public static Image flipVer(Image i) {
        BufferedImage bi = (BufferedImage) i;
        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -i.getWidth(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(bi, null);
    }
}