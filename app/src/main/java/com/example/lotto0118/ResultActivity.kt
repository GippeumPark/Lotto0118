package com.example.lotto0118

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity() {
    //안드로이드는 리소스를 정수 상수로 관리
    //이름 순으로 정렬해서 순서대로 번호를 부여
    //같은 용도로 사용되는 이미지는 일련번호를 마지막에 추가해서 만드는 것이 좋음
    //볼 시작 이미지의 아이디 저장
    val lottoImageStartId = R.drawable.ball_01

    //1~45 사이의 숫자 리스트를 받아서 이미지 뷰에 출력하는 메소드
    fun updateLottoBallImage(result:List<Int>){
        imageView01.setImageResource(lottoImageStartId + (result[0] - 1) )
        imageView02.setImageResource(lottoImageStartId + (result[1] - 1) )
        imageView03.setImageResource(lottoImageStartId + (result[2] - 1) )
        imageView04.setImageResource(lottoImageStartId + (result[3] - 1) )
        imageView05.setImageResource(lottoImageStartId + (result[4] - 1) )
        imageView06.setImageResource(lottoImageStartId + (result[5] - 1) )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        backButton.setOnClickListener{
            finish()
        }
        resultLabel.text = "랜덤하게 생성한\n로또 번호"
        //result에 저장된 데이터를 IntegetArray로 읽어오기
        val result = intent.getIntegerArrayListExtra("result")
        //이미지 뷰에 출력
        updateLottoBallImage(result!!.sortedBy { it })

        //constellation 값 가져오기
        val constellation = intent.getStringExtra("constellation")

        //데이터가 있다면 resultLabel 에 출력
        if(!TextUtils.isEmpty(constellation)){
            resultLabel.text = "${constellation}의\n로또 번호"
        }

        //name 값 가져오기
        val name = intent.getStringExtra("name")

        //데이터가 있다면 resultLabel 에 출력
        if(!TextUtils.isEmpty(name)){
            resultLabel.text = "${name}의\n로또 번호"
        }
    }
}