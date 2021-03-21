package com.example.temalaborator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment(): Fragment() {
    private var text = String()
    constructor(text: String) : this() {
        this.text = text;
    }
    companion object {
        fun newInstance() : Fragment {
            return SecondFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.second_fragment, container, false)
        val textView = view.findViewById<TextView>(R.id.text_view_second)
        textView.text = this.text;
        return view
    }
}