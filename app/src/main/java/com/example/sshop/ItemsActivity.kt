package com.example.sshop

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Активность для отображения списка товаров.
// Наследуется от AppCompatActivity и реализует стандартный жизненный цикл активности Android.
class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)

        // Получение ссылки на RecyclerView из макета
        val itemsList: RecyclerView = findViewById(R.id.item_list)

        // Создание и заполнение списка товаров тестовыми данными
        val items = arrayListOf<Item>()
        items.add(Item(1,"smth1","Riden","Genshin","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAa",10000))
        items.add(Item(2,"smth","Riden","Genshin","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAa",10000))
        items.add(Item(3,"smth1","Riden","Genshin","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAa",10000))
        items.add(Item(4,"smth","Riden","Genshin","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAa",10000))

        // Настройка RecyclerView:
        // 1. Установка LinearLayoutManager для линейного отображения элементов
        itemsList.layoutManager = LinearLayoutManager(this)
        // 2. Установка адаптера с передачей списка товаров и контекста
        itemsList.adapter = ItemsAdapter(items, this)
    }
}