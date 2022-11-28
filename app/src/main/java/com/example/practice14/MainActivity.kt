package com.example.practice14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arguments:Bundle? = intent.extras
        val editTextName:EditText=findViewById(R.id.editTextTextPersonName)
        val editTextEmail:EditText=findViewById(R.id.editTextTextEmailAddress)
        val editTextAge:EditText=findViewById(R.id.editTextNumber)
        if (arguments != null)
        {
            editTextName.setText("${arguments.get("name")}")
            editTextEmail.setText("${arguments.get("email")}")
            editTextAge.setText("${arguments.get("age")}")
        }
        editTextName.requestFocus()
    }

    fun activity2Button_Click(view: View) {
        val editTextName:EditText=findViewById(R.id.editTextTextPersonName)
        val editTextEmail:EditText=findViewById(R.id.editTextTextEmailAddress)
        val editTextAge:EditText=findViewById(R.id.editTextNumber)
        if (editTextName.text.isEmpty())
        {
            val toastName:Toast=Toast.makeText(applicationContext,"Введите имя!",Toast.LENGTH_SHORT)
            toastName.show()
            editTextName.requestFocus()
        }
        else if (editTextEmail.text.isEmpty())
        {
            val toastEmail:Toast=Toast.makeText(applicationContext,"Введите адрес почтового ящика!",Toast.LENGTH_SHORT)
            toastEmail.show()
            editTextEmail.requestFocus()
        }
        else if (editTextAge.text.isEmpty())
        {
            val toastAge:Toast=Toast.makeText(applicationContext,"Введите свой возраст!",Toast.LENGTH_SHORT)
            toastAge.show()
            editTextAge.requestFocus()
        }
        else if (editTextAge.text.toString().toDouble()>120)
        {
            val toastDino:Toast=Toast.makeText(applicationContext,"Вы динозавр?",Toast.LENGTH_SHORT)
            toastDino.show()
            editTextAge.requestFocus()
        }

        else {
            val intent: Intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("name", editTextName.text.toString())
            intent.putExtra("email", editTextEmail.text.toString())
            intent.putExtra("age", editTextAge.text.toString())
            startActivity(intent)
        }
    }
}