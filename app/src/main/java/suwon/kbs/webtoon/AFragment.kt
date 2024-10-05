package suwon.kbs.webtoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import suwon.kbs.webtoon.databinding.AfragmentBinding


class AFragment : Fragment() { 

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

      binding.webview1.webViewClient = WebtoonWebViewClient(binding.progressBar)
      binding.webview1.settings.javaScriptEnabled = true;
      binding.webview1.loadUrl("https://m.blog.naver.com/Recommendation.naver")

    }


    fun canGoBack() : Boolean {
        return binding.webview1.canGoBack();
    }


    fun goBack()  {
         binding.webview1.goBack();
    }
}