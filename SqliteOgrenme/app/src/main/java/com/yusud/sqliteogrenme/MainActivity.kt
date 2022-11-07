package com.yusud.sqliteogrenme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //try catch

        try {

            val veritabani = this.openOrCreateDatabase("Urunler", Context.MODE_PRIVATE,null)
           /* veritabani.execSQL("CREATE TABLE IF NOT EXISTS urunler (id INTEGER PRIMARY KEY, isim VARCHAR, fiyat INT)")
            veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('makarna',5)")
            veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('süt',11)")
            veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('pantolon',50)")
            veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('kamyon',10000)")
            veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('klavye',100)")*/

            // val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim  LIKE 'k%'",null)
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE id = 3",null)
            //val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim = 'pantolon'",null)
            //veritabani.execSQL("DELETE FROM urunler WHERE id = 5")
            //veritabani.execSQL("UPDATE urunler SET fiyat = 250 WHERE id = 6")

            val cursor = veritabani.rawQuery("SELECT * FROM urunler",null)

            val idColumnIndex = cursor.getColumnIndex("id")
            val isimColumnIndex = cursor.getColumnIndex("isim")
            val fiyatColumnIndex = cursor.getColumnIndex("fiyat")

            while(cursor.moveToNext()){
                println("ID: ${cursor.getInt(idColumnIndex)}")
                println("İSİM: ${cursor.getString(isimColumnIndex)}")
                println("Fiyat: ${cursor.getInt(fiyatColumnIndex)}")
            }
            cursor.close()

        }catch (e : Exception){
            e.printStackTrace()
        }
    }
}