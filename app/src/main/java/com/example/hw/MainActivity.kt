package com.example.hw

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var typein: EditText? = null
    private var Hint: TextView? = null
    private  var name:TextView? = null
    private  var winner:TextView? = null
    private  var our:TextView? = null
    private  var com:TextView? = null
    private var scissors: RadioButton? = null
    private  var rock:RadioButton? = null
    private  var paper:RadioButton? = null
    private  var start: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        typein=findViewById(R.id.typein);
        Hint=findViewById(R.id.Hint);
        name=findViewById(R.id.name);
        winner=findViewById(R.id.winner);
        our=findViewById(R.id.our);
        com=findViewById(R.id.com);
        scissors=findViewById(R.id.scissors);
        paper=findViewById(R.id.paper);
        rock=findViewById(R.id.rock);
        start=findViewById(R.id.start);

        start?.setOnClickListener(View.OnClickListener {
            if (typein?.length()!! < 1) {
                Hint?.text = "Pls type in your name!"
            } else {
                name?.text = String.format("name:\n%s", typein?.getText().toString())
                if (paper?.isChecked == true) {
                    our?.text = "you\npaper"
                } else if (scissors?.isChecked == true) {
                    our?.text = "you\nscissor"
                } else {
                    our?.text = "you\nrock"
                }
                val rand = (Math.random() * 3).toInt()
                if (rand == 0) {
                    com?.text = "com\npaper"
                } else if (rand == 1) {
                    com?.text = "com\nscissor"
                } else if (rand == 2) {
                    com?.text = "com\nrock"
                }
                if (((paper?.isChecked == true && rand == 2) || (scissors?.isChecked == true && rand == 0 )|| (rock?.isChecked == true && rand == 1))) {
                    Hint?.text = "You win"
                    winner?.text = "winner\nplayer"
                } else if (paper?.isChecked == true && rand == 1 || scissors?.isChecked == true && rand == 2 || rock?.isChecked == true && rand == 0) {
                    Hint?.text = "You lose"
                    winner?.text = "winner\nCOM"
                } else {
                    Hint?.text = "oh~come on\ntry again!"
                    winner?.text = "winner\nnobody"
                }
            }
        })
    }
}