package com.example.sshop

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// класс для работы с SQL
class DbHelper(val context: Context, val factory:
    SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, "appDataBase",factory,1){

        // метод создания sql таблицы
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT, email TEXT, pass TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    // метод заполнения таблицы
    fun addUsers(user: User){
        val values = ContentValues()
        values.put("login", user.log)
        values.put("email", user.email)
        values.put("pass", user.pass)

        val db = this.writableDatabase
        db.insert("users", null, values)

        db.close()
    }

    // метод получения данных пользователя
    fun getUser(log: String, pass: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users WHERE login = ? AND pass = ?", arrayOf(log, pass))
        val result = cursor.moveToFirst()
        cursor.close()
        return result
    }

}