package com.example.navigationcomponents


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v:View = inflater.inflate(R.layout.fragment_home, container, false)
        val rb:Button = v.findViewById(R.id.red)
        val gb:Button = v.findViewById(R.id.green)
        val bb:Button = v.findViewById(R.id.blue)
        rb.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_redFragment)

        }
        gb.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_greenFragment)

        }
        bb.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_blueFragment)

        }
        return v
    }


}
