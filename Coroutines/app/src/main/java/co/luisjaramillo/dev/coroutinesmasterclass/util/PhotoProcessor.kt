package co.luisjaramillo.dev.coroutinesmasterclass.util

import android.graphics.Bitmap

object PhotoProcessor {
    fun findDominantColor(image: Bitmap): Int {
        val colorCounts = mutableMapOf<Int, Int>()
        for (x in 0 until image.width) {
            for (y in 0 until image.height) {
                val pixelColor = image.getPixel(x, y)
                colorCounts[pixelColor] = colorCounts.getOrDefault(pixelColor, 0) + 1
            }
        }
        return colorCounts.entries.sortedByDescending { it.value }
            .take(1)
            .map { it.key }
            .first()
    }

    /**
     *     fun findDominantColor(image: Bitmap): Int {
     *         val colorCounts = mutableMapOf<Int, Int>()
     *         for (x in 0 until image.width) {
     *             for (y in 0 until image.height) {
     *                 val pixel = image.getPixel(x, y)
     *                 if ((pixel shr 24) and 0xFF < 128) continue
     *                 val groupedColor = pixel and 0xFFF8F8F8.toInt()
     *                 if (isTooWhite(groupedColor)) continue
     *                 colorCounts[groupedColor] = colorCounts.getOrDefault(groupedColor, 0) + 1
     *             }
     *         }
     *         return colorCounts.entries.sortedByDescending { it.value }
     *             .take(1)
     *             .map { it.key }
     *             .first()
     *     }
     *     private fun isTooWhite(color: Int): Boolean {
     *         val r = (color shr 16) and 0xFF
     *         val g = (color shr 8) and 0xFF
     *         val b = color and 0xFF
     *         return r > 240 && g > 240 && b > 240
     *     }
     */
}