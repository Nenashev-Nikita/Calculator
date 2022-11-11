package com.projec.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
aboba
    private var inputStr: String = ""
    private val operations = "*/+-."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculator: Calculator = Calculator()

        val textView: TextView = findViewById(R.id.textView4)
        val historyTextView: TextView = findViewById(R.id.textView)

        val buttonOne: Button = findViewById(R.id.button_one)
        buttonOne.setOnClickListener {
            inputStr += "1"
            textView.text = inputStr
        }

        val buttonTwo: Button = findViewById(R.id.button_two)
        buttonTwo.setOnClickListener {
            inputStr += "2"
            textView.text = inputStr
        }

        val buttonThree: Button = findViewById(R.id.button_three)
        buttonThree.setOnClickListener {
            inputStr += "3"
            textView.text = inputStr
        }

        val buttonFour: Button = findViewById(R.id.button_four)
        buttonFour.setOnClickListener {
            inputStr += "4"
            textView.text = inputStr
        }

        val buttonFive: Button = findViewById(R.id.button_five)
        buttonFive.setOnClickListener {
            inputStr += "5"
            textView.text = inputStr
        }

        val buttonSix: Button = findViewById(R.id.button_six)
        buttonSix.setOnClickListener {
            inputStr += "6"
            textView.text = inputStr
        }

        val buttonSeven: Button = findViewById(R.id.button_seven)
        buttonSeven.setOnClickListener {
            inputStr += "7"
            textView.text = inputStr
        }

        val buttonEight: Button = findViewById(R.id.button_eight)
        buttonEight.setOnClickListener {
            inputStr += "8"
            textView.text = inputStr
        }

        val buttonNine: Button = findViewById(R.id.button_nine)
        buttonNine.setOnClickListener {
            inputStr += "9"
            textView.text = inputStr
        }

        val buttonZero: Button = findViewById(R.id.button13)
        buttonZero.setOnClickListener {
            inputStr += "0"
            textView.text = inputStr
        }

        val buttonPlus: Button = findViewById(R.id.button11)
        buttonPlus.setOnClickListener {
            if (inputStr.length == 0)
                textView.text = inputStr
            else if (inputStr[inputStr.length - 1] !in operations) {
                inputStr += "+"
                textView.text = inputStr
            }
        }

        val buttonMinus: Button = findViewById(R.id.button23)
        buttonMinus.setOnClickListener {
            if (inputStr.length == 0)
                textView.text = inputStr
            else if (inputStr[inputStr.length - 1] !in operations) {
                inputStr += "-"
                textView.text = inputStr
            }
        }

        val buttonMultiply: Button = findViewById(R.id.button22)
        buttonMultiply.setOnClickListener {
            if (inputStr.length == 0)
                textView.text = inputStr
            else if (inputStr[inputStr.length - 1] !in operations) {
                inputStr += "*"
                textView.text = inputStr
            }
        }

        val buttonDivide: Button = findViewById(R.id.button9)
        buttonDivide.setOnClickListener {
            if (inputStr.length == 0)
                textView.text = inputStr
            else if (inputStr[inputStr.length - 1] !in operations) {
                inputStr += "/"
                textView.text = inputStr
            }
        }

        val buttonDelete: Button = findViewById(R.id.button10)
        buttonDelete.setOnClickListener {
            inputStr = inputStr.replaceFirst(".$".toRegex(), "")
            textView.text = inputStr
        }

        val buttonClear: Button = findViewById(R.id.button15)
        buttonClear.setOnClickListener {
            inputStr = ""
            textView.text = inputStr
        }

        val buttonLeftBracket: Button = findViewById(R.id.button5)
        buttonLeftBracket.setOnClickListener {
            inputStr += "("
            textView.text = inputStr
        }

        val buttonRightBracket: Button = findViewById(R.id.button7)
        buttonRightBracket.setOnClickListener {
            inputStr += ")"
            textView.text = inputStr
        }

        val buttonDot: Button = findViewById(R.id.button4)
        buttonDot.setOnClickListener {
            if (inputStr.length == 0)
                textView.text = inputStr
            else if (inputStr[inputStr.length - 1] !in operations) {
                inputStr += "."
                textView.text = inputStr
            }
        }

        val buttonIs: Button = findViewById(R.id.button12)
        buttonIs.setOnClickListener {
            if (inputStr.length == 0)
                textView.text = inputStr
            else if (inputStr[inputStr.length - 1] !in operations) {
                textView.text = inputStr
                inputStr = calculator.calc(inputStr)
                historyTextView.text = inputStr
            }
        }
    }
}