package com.example.lotto0118

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    //1~45까지 숫자 중 하나를 랜덤하게 리턴해주는 함수 생성
    fun getRandomLottoNumber():Int{
        return Random().nextInt(45)+1
    }
    //1~45까지 숫자 6개를 List로 만들어서 리턴하는 메소드
    //숫자는 중복되지 않게 생성
    fun getRandomLottoNumbers():MutableList<Int>{
        //정수를 저장할 List 생성
        val lottoNumbers = mutableListOf<Int>()

        for (i in 1..6){
            var number = 0
            do{
                //랜덤한 숫자를 가져와서
                number = getRandomLottoNumber()
                //lottoNumbers에 있으면 다시 가져오기
            }while(lottoNumbers.contains(number))

            lottoNumbers.add(number)
        }
        return lottoNumbers
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //랜덤 카드 뷰의 클릭 이벤트 처리
        randomCard.setOnClickListener{
            val intent = Intent(this, ResultActivity::class.java)
            //데이터 저장
            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
            startActivity(intent)
        }
        //별자리 카드 뷰의 클릭 이벤트 처리
        constellationCard.setOnClickListener{
            val intent = Intent(this, ConstellationActivity::class.java)
            startActivity(intent)
        }

        //이름 카드 뷰의 클릭 이벤트 처리
        nameCard.setOnClickListener{
            val intent = Intent(this, NameActivity::class.java)
            startActivity(intent)
        }
    }
}