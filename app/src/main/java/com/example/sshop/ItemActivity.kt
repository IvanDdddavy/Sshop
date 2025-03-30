package com.example.sshop

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

// Activity для отображения детальной информации о товаре.
// Получает данные через Intent и отображает название и описание товара.
class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item)

        // Ключи для передачи данных через Intent
        val title: TextView = findViewById(R.id.item_list_title_one)
        val text: TextView = findViewById(R.id.item_list_text)
        val prc: TextView = findViewById(R.id.item_list_price)
        val img: ImageView = findViewById(R.id.item_list_image_one)

        val price = intent.getIntExtra("itemPrice", 0)

        val imag = intent.getStringExtra("itemImage")
        @SuppressLint("DiscouragedApi")
        val resId = resources.getIdentifier(imag, "drawable", packageName)

        // Инициализация TextView для отображения данных
        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        prc.text = price.toString()
        img.setImageResource(resId)

    }
}