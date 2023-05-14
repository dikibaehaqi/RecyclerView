package com.dikibaehaqi.recyclerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dikibaehaqi.recyclerview2.adapter.AdapterTeamBola
import com.dikibaehaqi.recyclerview2.databinding.ActivityMainBinding
import com.dikibaehaqi.recyclerview2.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Ibrahimovic",R.drawable.ibrahimovic,"Penyerang","1.95","Malmo (Swedia)","03 Oktober 1981"))
        listPemain.add(Pemain("giroud",R.drawable.giroud,"Penyerang","1.93","Chambery (Prancis)","30 September 1986"))
        listPemain.add(Pemain("leao",R.drawable.leao,"Penyerang","1.94","Almada Setubal (Portugal)","10 Juni 1999"))
        listPemain.add(Pemain("theo",R.drawable.theo,"Belakang","1.87","Marseille (Prancis)","06 Oktober 1997"))
        listPemain.add(Pemain("maignan",R.drawable.maignan,"Penjaga Gawang","1.91","Cayenne (Prancis)","03 Juli 1995"))

        binding.list.adapter = AdapterTeamBola(this,listPemain, object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {

            }

        })



    }

}