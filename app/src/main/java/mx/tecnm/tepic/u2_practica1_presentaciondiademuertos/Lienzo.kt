package mx.tecnm.tepic.u2_practica1_presentaciondiademuertos

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.View

class Lienzo(p:MainActivity) : View(p) {
    var principal = p
    var tumba_negra = BitmapFactory.decodeResource(principal.resources, R.drawable.tumba_negra)
    var tumba_rota = BitmapFactory.decodeResource(principal.resources, R.drawable.tumba_rota)
    var lapida_1 = BitmapFactory.decodeResource(principal.resources, R.drawable.tombstone)
    var lapida_2 = BitmapFactory.decodeResource(principal.resources, R.drawable.tombstone_)
    var witch = BitmapFactory.decodeResource(principal.resources, R.drawable.witch)
    var catrina_grande = BitmapFactory.decodeResource(principal.resources, R.drawable.catrina_pie)
    var flores = BitmapFactory.decodeResource(principal.resources, R.drawable.flores_2)
    var ofrenda1 = BitmapFactory.decodeResource(principal.resources, R.drawable.ofrenda_1)
    var ofrenda2 = BitmapFactory.decodeResource(principal.resources, R.drawable.ofrenda_2)
    var posXNube = 0f
    var posXWitch = 0f

    var posXCatrina = -200f

    var movimientoNubesWitch = object: CountDownTimer(2000, 80){
        override fun onTick(p0: Long) {
            posXNube +=1f
            if(posXNube > 1037)posXNube = posXNube*-1

            posXWitch += 5f
            if(posXWitch >= 1757) posXWitch = 0f
            invalidate()

        }

        override fun onFinish() {
            start()
        }

    }

    var movimientoCatrina = object : CountDownTimer(2000, 80) {
        override fun onTick(p0: Long) {
            posXCatrina +=7f
            if(posXCatrina >= 1800)posXCatrina=-200f
            invalidate()

        }

        override fun onFinish() {
            start()
        }
    }

    init {
        movimientoNubesWitch.start()
        movimientoCatrina.start()
    }

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
        //val ancho = 1557
        //val alto = 538
        (1..500).forEach {
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

        // WITCH
        c.drawBitmap(witch,posXWitch, 70f, p)

        //---------------------------------------------Nubes
        //p.color = Color.argb(255,134,177,221)
        p.color = Color.rgb(180,203,217)
        // NUBE 1
        c.drawOval(590f-posXNube, 70f, 680f-posXNube, 150f,p)
        c.drawOval(640f-posXNube, 20f, 720f-posXNube, 110f,p)
        c.drawOval(690f-posXNube, 20f, 780f-posXNube, 110f,p)
        c.drawOval(650f-posXNube, 85f, 730f-posXNube, 180f,p)
        c.drawOval(720f-posXNube, 90f, 800f-posXNube, 170f,p)

        // NUBE 2
        c.drawOval(820f+posXNube, 70f, 910f+posXNube, 150f,p)
        c.drawOval(870f+posXNube, 20f, 950f+posXNube, 110f,p)
        c.drawOval(920f+posXNube, 20f, 1010f+posXNube, 110f,p)
        c.drawOval(880f+posXNube, 85f, 960f+posXNube, 180f,p)
        c.drawOval(950f+posXNube, 90f, 1030f+posXNube, 170f,p)

        // NUBE 3 - pequeña
        c.drawOval(1220f-posXNube, 70f, 1310f-posXNube, 150f,p)
        c.drawOval(1270f-posXNube, 20f, 1350f-posXNube, 110f,p)
        c.drawOval(1320f-posXNube, 20f, 1410f-posXNube, 110f,p)
        c.drawOval(1280f-posXNube, 85f, 1360f-posXNube, 180f,p)
        c.drawOval(1350f-posXNube, 90f, 1430f-posXNube, 170f,p)

        // NUBE 4 - pequeña
        c.drawOval(120f+posXNube, 70f, 210f+posXNube, 150f,p)
        c.drawOval(170f+posXNube, 20f, 250f+posXNube, 110f,p)
        c.drawOval(220f+posXNube, 20f, 310f+posXNube, 110f,p)
        c.drawOval(180f+posXNube, 85f, 260f+posXNube, 180f,p)
        c.drawOval(250f+posXNube, 90f, 330f+posXNube, 170f,p)

        // Cerros
        p.color = Color.rgb(27,55,87)
        c.drawOval(0f, ((alto/2)-80).toFloat(), (ancho/2).toFloat(), ((alto/2)*2).toFloat(),p)
        c.drawOval(((ancho/2)-30).toFloat(), ((alto/2)-80).toFloat(), ((ancho/2)*2).toFloat(), ((alto/2)*2).toFloat(),p)
        //c.drawRect(0f, (((alto/2)*2)-(alto/2)).toFloat(),ancho.toFloat(), ((alto/2)*2).toFloat(),p)
        c.drawRect(0f, (((alto/2)*2)-(alto/2)+50).toFloat(),ancho.toFloat(), ((alto/2)*2).toFloat(),p)


        // Árboles
        p.color = Color.BLACK
        // ARBOL 1
        c.drawRect(70f, 200f, 80f, 280f, p)
        c.drawOval(55f, 150f, 95f, 230f, p)

        // ARBOL 2
        c.drawRect(100f, 230f, 110f, 310f, p)
        c.drawOval(85f, 180f, 125f, 260f, p)

        //Lapidas
        c.drawBitmap(tumba_negra,90f, 290f, p)
        c.drawBitmap(tumba_negra,150f, 230f, p)
        c.drawBitmap(tumba_negra,250f, 230f, p)

        c.drawBitmap(tumba_negra,800f, 240f, p)
        c.drawBitmap(tumba_negra,950f, 170f, p)
        c.drawBitmap(tumba_negra,1100f, 230f, p)
        c.drawBitmap(tumba_negra,1300f, 260f, p)
        c.drawBitmap(tumba_negra,1400f, 250f, p)

        //ARBOL
        p.color = Color.rgb(98, 102, 18)
        c.drawOval(ancho.toFloat()-855, (alto/2).toFloat()-100, ancho.toFloat()-915,alto.toFloat()-170,p)
        p.color = Color.rgb(81, 84, 43)
        c.drawRect(ancho.toFloat()-870,(alto.toFloat())/2, ancho.toFloat()-900, alto.toFloat()-100,p)

        c.drawBitmap(lapida_1,150f, 250f, p)
        c.drawBitmap(flores, 250f, 400f,p)
        c.drawBitmap(lapida_2,400f, 240f, p)

        //Mover catrina
        c.drawBitmap(catrina_grande,posXCatrina, 100f,p)

        c.drawBitmap(lapida_1,700f, 280f, p)
        c.drawBitmap(ofrenda1, 740f, 400f,p)
        c.drawBitmap(lapida_2,990f, 300f, p)
        c.drawBitmap(ofrenda2, 1000f, 400f,p)
        c.drawBitmap(lapida_1,1300f, 320f, p)

        // ARBOL 3
        p.color = Color.rgb(98, 102, 18)
        c.drawOval(ancho.toFloat()-100,(alto.toFloat()-190)/2, ancho.toFloat()+100, alto.toFloat()-100,p)
        p.color = Color.rgb(81, 84, 43)
        c.drawRect(ancho.toFloat()-30,(alto.toFloat()+100)/2, ancho.toFloat(), alto.toFloat(),p)
    }
}