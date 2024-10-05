package suwon.kbs.webtoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import suwon.kbs.webtoon.databinding.BfragmentBinding

class BFragment : Fragment() {

    private lateinit var binding: BfragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BfragmentBinding.inflate(inflater)
        return binding.root
    }
}


