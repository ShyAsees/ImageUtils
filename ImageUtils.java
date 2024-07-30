// this function converts bitmap in to byte array. 
//input format ARGB8888 output 8 bit bytearray for STM32

import java.io.ByteArrayOutputStream;
import java.util.Base64;

public static String convertImageToFormattedString(Bitmap bitmap) {
    int width = bitmap.getWidth();
    int height = bitmap.getHeight();

    StringBuilder builder = new StringBuilder();
    builder.append("image_bytearray = {");

    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            int pixel = bitmap.getPixel(x, y);
            byte[] argb = new byte[4];
            argb[0] = (byte) ((pixel >> 24) & 0xFF); // Alpha
            argb[1] = (byte) ((pixel >> 16) & 0xFF); // Red
            argb[2] = (byte) ((pixel >> 8) & 0xFF);  // Green
            argb[3] = (byte) (pixel & 0xFF);         // Blue
            for (byte b : argb) {
                builder.append(String.format("0x%02X, ", b));
            }
        }
        builder.append("\n");
    }
}

// Method to convert Bitmap to Base64
    public static String convertBitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }
