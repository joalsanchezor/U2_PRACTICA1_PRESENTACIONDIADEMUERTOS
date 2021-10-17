package mx.tecnm.tepic.u2_practica1_presentaciondiademuertos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo(p:MainActivity) : View(p) {
    var principal = p

    override fun onDraw(c: Canvas){
        super.onDraw(c)

        val p = Paint()
        c.drawColor(Color.rgb(9, 49, 66))

        // LUNA LLENA
        p.color = Color.WHITE
        c.drawCircle(800f, 100f, 80f, p)
        p.style = Paint.Style.STROKE
        p.strokeWidth = 25f
        p.color = Color.argb(50, 58,128,130)
        c.drawCircle(800f,100f,80f,p)
        //Cráteres
        p.style = Paint.Style.FILL
        p.color = Color.LTGRAY
        c.drawCircle(840f, 90f, 15f, p)
        c.drawCircle(810f, 100f, 10f, p)

        //---------------------------------------------Nubes
        // NUBE 1
        c.drawOval(610f, 70f, 700f, 150f,p)
        c.drawOval(660f, 20f, 740f, 110f,p)
        c.drawOval(710f, 20f, 800f, 110f,p)
        c.drawOval(670f, 85f, 750f, 180f,p)
        c.drawOval(740f, 90f, 820f, 170f,p)

        // NUBE 2
        c.drawOval(110f, 70f, 200f, 150f,p)
        c.drawOval(160f, 20f, 240f, 110f,p)
        c.drawOval(210f, 20f, 300f, 110f,p)
        c.drawOval(170f, 85f, 250f, 180f,p)
        c.drawOval(240f, 90f, 320f, 170f,p)



    }
}