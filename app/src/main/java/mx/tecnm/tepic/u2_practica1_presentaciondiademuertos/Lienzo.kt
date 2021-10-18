package mx.tecnm.tepic.u2_practica1_presentaciondiademuertos

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo(p:MainActivity) : View(p) {
    var principal = p

    @SuppressLint("NewApi")
    override fun onDraw(c: Canvas){
        super.onDraw(c)

        val p = Paint()
        //c.drawColor(Color.rgb(9, 49, 66))
        c.drawColor(Color.rgb(1, 27, 56))

        // Cielo Estrellado
        p.color = Color.WHITE
        val ancho = width
        val alto = height
        (1..5000).forEach {
            var x = (Math.random()*ancho).toFloat()
            var y = (Math.random()*alto).toFloat()
            c.drawPoint(x,y,p)
        }

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
        //p.color = Color.argb(255,134,177,221)
        p.color = Color.rgb(180,203,217)
        // NUBE 1
        c.drawOval(590f, 70f, 680f, 150f,p)
        c.drawOval(640f, 20f, 720f, 110f,p)
        c.drawOval(690f, 20f, 780f, 110f,p)
        c.drawOval(650f, 85f, 730f, 180f,p)
        c.drawOval(720f, 90f, 800f, 170f,p)

        // NUBE 2
        c.drawOval(820f, 70f, 910f, 150f,p)
        c.drawOval(870f, 20f, 950f, 110f,p)
        c.drawOval(920f, 20f, 1010f, 110f,p)
        c.drawOval(880f, 85f, 960f, 180f,p)
        c.drawOval(950f, 90f, 1030f, 170f,p)

        // NUBE 3 - pequeña
        c.drawOval(1220f, 70f, 1310f, 150f,p)
        c.drawOval(1270f, 20f, 1350f, 110f,p)
        c.drawOval(1320f, 20f, 1410f, 110f,p)
        c.drawOval(1280f, 85f, 1360f, 180f,p)
        c.drawOval(1350f, 90f, 1430f, 170f,p)

        // NUBE 4 - pequeña
        c.drawOval(120f, 70f, 210f, 150f,p)
        c.drawOval(170f, 20f, 250f, 110f,p)
        c.drawOval(220f, 20f, 310f, 110f,p)
        c.drawOval(180f, 85f, 260f, 180f,p)
        c.drawOval(250f, 90f, 330f, 170f,p)



    }
}