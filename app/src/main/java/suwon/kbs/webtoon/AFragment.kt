package suwon.kbs.webtoon

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import suwon.kbs.webtoon.databinding.AfragmentBinding


class AFragment(private val position : Int) : Fragment() {

    private lateinit var binding: AfragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AfragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      binding.webview1.webViewClient = WebtoonWebViewClient(binding.progressBar) {
          url -> activity?.getSharedPreferences("WEB_HISTORY",Context.MODE_PRIVATE)?.edit {
              putString("tab${position}",url)
      }
      }
      binding.webview1.settings.javaScriptEnabled = true;
      binding.webview1.loadUrl("https://comic.naver.com/webtoon/")

      binding.goHome.setOnClickListener {
          val sharedPreferences = activity?.getSharedPreferences("WEB_HISTORY",Context.MODE_PRIVATE)
          val url = sharedPreferences?.getString("tab${position}","");

          if(url.isNullOrEmpty()){
              Toast.makeText(context,"마지막 저장 시점이 없습니다.",Toast.LENGTH_SHORT).show()

          }else{
              binding.webview1.loadUrl(url)
          }




      }

    }


    fun canGoBack() : Boolean {
        return binding.webview1.canGoBack();
    }


    fun goBack()  {
         binding.webview1.goBack();
    }
}