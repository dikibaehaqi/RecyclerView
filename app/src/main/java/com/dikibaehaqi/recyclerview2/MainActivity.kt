package com.dikibaehaqi.recyclerview2

import android.app.Dialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
        listPemain.add(Pemain("Ibrahimovic",R.drawable.ibrahimovic,"Penyerang","1.95 M","Malmo (Swedia)","03 Oktober 1981"))
        listPemain.add(Pemain("Giroud",R.drawable.giroud,"Penyerang","1.93 M","Chambery (Prancis)","30 September 1986"))
        listPemain.add(Pemain("Leao",R.drawable.leao,"Penyerang","1.94 M","Almada Setubal (Portugal)","10 Juni 1999"))
        listPemain.add(Pemain("Theo",R.drawable.theo,"Belakang","1.87 M","Marseille (Prancis)","06 Oktober 1997"))
        listPemain.add(Pemain("Maignan",R.drawable.maignan,"Penjaga Gawang","1.91 M","Cayenne (Prancis)","03 Juli 1995"))

        binding.list.adapter = AdapterTeamBola(this,listPemain, object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val  image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }

                }.show()

            }

        })



    }

}