package com.example.sshop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


//  Activity для авторизации пользователя.
//  Позволяет войти в систему или перейти к регистрации.
class AuthActivity : AppCompatActivity() {

    //Создание активности и инициализация UI компонентов.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)

        // Инициализация UI элементов
        val userLog: EditText = findViewById(R.id.user_log_auth)
        val userPassword: EditText = findViewById(R.id.user_pass_auth)
        val buttonAuth : Button = findViewById(R.id.button_auth)
        val buttonToReg: Button = findViewById(R.id.button_to_reg)

        // Обработчик кнопки перехода к регистрации
        buttonToReg.setOnClickListener {
            // Создаем Intent для перехода к MainActivity (регистрации)
            val intent  = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Обработчик кнопки авторизации
        buttonAuth.setOnClickListener{
            // Получаем введенные данные
            val log = userLog.text.toString().trim()
            val pass = userPassword.text.toString().trim()

            // Валидация полей ввода
            if (log == "" || pass == "") {
                Toast.makeText(this, "Заполните поля", Toast.LENGTH_LONG).show()
            }else{
                // Проверка учетных данных через базу данных
                val db = DbHelper(this,null)
                val isAuth = db.getUser(log, pass)

                if (isAuth){
                    // Успешная авторизация
                    Toast.makeText(this, "Аторизация успешна", Toast.LENGTH_LONG).show()
                    userLog.text.clear()
                    userPassword.text.clear()

                    // Переход к главной след активити
                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                }else{
                    // Неудачная авторизация
                    Toast.makeText(this, "Проверьте логин/пароль", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}