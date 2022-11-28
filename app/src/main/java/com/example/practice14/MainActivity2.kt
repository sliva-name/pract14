package com.example.practice14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val arguments:Bundle? = intent.extras
        val editTextName2:EditText=findViewById(R.id.editTextTextPersonName2)
        val editTextEmail2:EditText=findViewById(R.id.editTextTextEmailAddress2)
        val editTextAge2:EditText=findViewById(R.id.editTextNumber2)
        if (arguments != null)
        {
            editTextName2.setText("${arguments.get("name")}")
            editTextEmail2.setText("${arguments.get("email")}")
            editTextAge2.setText("${arguments.get("age")}")
        }
    }

    fun buttonHome_Click(view: View) {
        val editTextName2:EditText=findViewById(R.id.editTextTextPersonName2)
        val editTextEmail2:EditText=findViewById(R.id.editTextTextEmailAddress2)
        val editTextAge2:EditText=findViewById(R.id.editTextNumber2)
        val arguments:Bundle? = intent.extras
        if (editTextName2.text.isEmpty())
        {
            val toastName: Toast = Toast.makeText(applicationContext,"Введите имя!", Toast.LENGTH_SHORT)
            toastName.show()
            editTextName2.requestFocus()
        }
        else if (editTextEmail2.text.isEmpty())
        {
            val toastEmail: Toast =
                Toast.makeText(applicationContext,"Введите адрес почтового ящика!", Toast.LENGTH_SHORT)
            toastEmail.show()
            editTextEmail2.requestFocus()
        }
        else if (editTextAge2.text.isEmpty())
        {
            val toastAge: Toast = Toast.makeText(applicationContext,"Введите свой возраст!", Toast.LENGTH_SHORT)
            toastAge.show()
            editTextAge2.requestFocus()
        }
        else if (editTextAge2.text.toString().toDouble()>120)
        {
            val toastDino: Toast = Toast.makeText(applicationContext,"Вы динозавр?", Toast.LENGTH_SHORT)
            toastDino.show()
            editTextAge2.requestFocus()
        }
        else if (editTextName2.text.toString()==arguments?.get("name").toString()&&
                editTextEmail2.text.toString()==arguments?.get("email").toString()&&
                editTextAge2.text.toString()==arguments?.get("age").toString())
        {
            val toastChange: Toast = Toast.makeText(applicationContext,"Измените данные!", Toast.LENGTH_SHORT)
            toastChange.show()
        }
        else {
            val intent: Intent = Intent(this@MainActivity2, MainActivity::class.java)
            intent.putExtra("name", "${editTextName2.text.toString()}*")
            intent.putExtra("email", "${editTextEmail2.text.toString()}*")
            intent.putExtra("age", "${editTextAge2.text.toString()}*")
            startActivity(intent)
        }
    }
}