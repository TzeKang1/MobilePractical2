package com.example.mobilepractical2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.mobilepractical2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val myName2: MyName = MyName("BAIT")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName =myName2
        //setContentView(R.layout.activity_main)

        binding.doneButton.setOnClickListener{
            addNickname(it)
        }

        binding.nicknameText.setOnClickListener{
            addNickname(it)
        }
    }

    /**
     * Click handler for the DONE button.
     * Hides the EditText and the DONE button.
     * Sets the EditText content to the TextView and displays it.
     */
    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

//        binding.nicknameText.text = binding.nicknameEdit.text.toString()
//        binding.nicknameEdit.visibility = View.GONE
//        binding.doneButton.visibility = View.GONE
//        binding.nicknameText.visibility = View.VISIBLE
        binding.apply{
//            nicknameText.text = binding.nicknameEdit.text.toString()
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

    /**
     * Click handler for the nickname TextView.
     * Displays the EditText and the DONE button.
     * Hides the nickname TextView.
     */
    private fun updateNickname(view: View) {
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val doneButton = findViewById<Button>(R.id.done_button)

        binding.apply{
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
        }
//        editText.visibility = View.VISIBLE
//        doneButton.visibility = View.VISIBLE
//        view.visibility = View.GONE
    }
}