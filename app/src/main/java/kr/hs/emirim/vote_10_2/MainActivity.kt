package kr.hs.emirim.vote_10_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "캐릭터 선호도 투표"

        //1차원 배열 int[] voteCount = new int[9];
        var voteCount = IntArray(9)

        for(i in 0..8)
            voteCount[i] = 0

        var imgv = arrayOfNulls<ImageView>(9)
        var imgvId = arrayOf(R.id.ch1,R.id.ch2,R.id.ch3,R.id.ch4,R.id.ch5,R.id.ch6,R.id.ch7,R.id.ch8,R.id.ch9)

        var imgName = arrayOf("헬로키티","마이멜로디","쿠로미","폼폼푸린","시나모롤","리틀스타","포차코","케로케로케로피","배드마츠마루")

        for(i in imgvId.indices){
            imgv[i] = findViewById(imgvId[i])
            imgv[i]!!.setOnClickListener{
                voteCount[i]++
                Toast.makeText(applicationContext,imgName[i]+": "+voteCount[i]+"표", Toast.LENGTH_SHORT).show()
            }
        }
        var btnResult = findViewById<Button>(R.id.btnResult)
        btnResult.setOnClickListener{
            var intent = Intent(applicationContext,ResultActivity::class.java)
            intent.putExtra("voteCount",voteCount)
            intent.putExtra("imgName",imgName)
            startActivity(intent)
        }


    }
}