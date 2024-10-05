package suwon.kbs.webtoon

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import suwon.kbs.webtoon.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    //콜백 인스턴스 생성
    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            // 뒤로 버튼 이벤트 처리
            Log.e("KBS", "뒤로가기 클릭")

            val currentFragment = supportFragmentManager.fragments[binding.viewPager.currentItem]

            if(currentFragment is AFragment) {
                if(currentFragment.canGoBack()){
                    currentFragment.goBack();
                }else{

                    Log.e("KBS", "뒤로가기 불가능1")
                    finish();
                }
            }else {
                Log.e("KBS", "뒤로가기 불가능2")
                finish();
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.viewPager.adapter = ViewPagerAdapter(this);

        TabLayoutMediator(binding.tabLayout , binding.viewPager){ tab, position ->
            run {
                val textView = TextView(this@MainActivity)
                textView.text = "position $position";
                textView.gravity = Gravity.CENTER
                tab.customView = textView;
            }
        }.attach()




        this.onBackPressedDispatcher.addCallback(this, callback) //위에서 생성한 콜백 인스턴스 붙여주기

    }



}