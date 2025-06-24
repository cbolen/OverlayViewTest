package com.example.custompreviewoverlay // Adjust to your package name

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class OverlayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val rectanglePaint = Paint().apply {
        //style = Paint.Style.STROKE
        style = Paint.Style.FILL_AND_STROKE
        color = Color.GREEN
        strokeWidth = 10f
        alpha = 100 // 0 (transparent) to 255 (opaque)
    }

    private val rectangleCoordinates = RectF()

    private fun updateRectangleCoordinates(viewWidth: Int, viewHeight: Int) {
        val rectWidth = viewWidth * 0.7f
        val rectHeight = viewHeight * 0.4f
        val left = (viewWidth - rectWidth) / 2f
        val top = (viewHeight - rectHeight) / 2f
        val right = left + rectWidth
        val bottom = top + rectHeight
        rectangleCoordinates.set(left, top, right, bottom)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        updateRectangleCoordinates(w, h)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(rectangleCoordinates, rectanglePaint)
    }
}