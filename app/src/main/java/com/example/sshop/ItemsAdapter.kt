package com.example.sshop

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//  Адаптер для RecyclerView, который отображает список товаров.
//  @param items Список объектов Item для отображения
//  @param context Контекст приложения (обычно Activity)
class ItemsAdapter(var items: List<Item>, var context: Context):
    RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {


//      Класс ViewHolder для хранения ссылок на views элементов списка.
//      @param view Корневое view элемента списка
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.item_list_image)
        val title: TextView = view.findViewById(R.id.item_list_title)
        val desc: TextView = view.findViewById(R.id.item_list_desc)
        val price: TextView = view.findViewById(R.id.item_list_price)
        val  btn: Button = view.findViewById(R.id.item_list_button)
    }

//      Создает новый ViewHolder при необходимости.
//      @param p0 Родительская ViewGroup
//      @param p1 Тип view (не используется в данной реализации)
//      @return Новый экземпляр MyViewHolder
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_in_list, p0, false)
        return MyViewHolder(view)
    }


//      Возвращает общее количество элементов в списке.
//      @return Количество элементов
    override fun getItemCount(): Int {
        return items.count()
    }


//      Привязывает данные к ViewHolder для указанной позиции.
//      @param holder ViewHolder для заполнения
//      @param position Позиция элемента в списке
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Установка текстовых данных
        holder.title.text = items[position].title
        holder.desc.text = items[position].desc
        holder.price.text = items[position].price.toString()

    // Получение идентификатора изображения из ресурсов
        @SuppressLint("DiscouragedApi")
        val imageId = context.resources.getIdentifier(
            items[position].image, // имя ресурса
            "drawable", // тип ресурса
            context.packageName // имя пакета
        )

    // Установка изображения
        holder.image.setImageResource(imageId)

    // Обработчик нажатия на кнопку
        holder.btn.setOnClickListener{
            // Создание Intent для перехода к детальной информации о товаре
            val intent = Intent(context, ItemActivity::class.java)

            // Передача данных о товаре
            intent.putExtra("itemTitle", items[position].title)
            intent.putExtra("itemText", items[position].text)
            intent.putExtra("itemPrice", items[position].price)
            intent.putExtra("itemImage", items[position].image)

            // Запуск Activity
            context.startActivity(intent)
        }
    }
}