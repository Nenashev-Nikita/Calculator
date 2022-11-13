package com.projec.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var inputStr: String = ""
    private var subInputStr: String = ""
    private var outputStr: String = ""
    private val operations = "*/+-."
    private val wkOperations = "*/+-()"
    private var isActive: Boolean = false

    private val calculator: Calculator = Calculator()

    private fun printRes(inputStr: String): String {
        /*if (inputStr.isNotEmpty() && inputStr[inputStr.length - 1] in wkOperations) {
            outputStr = inputStr.replaceFirst(".$".toRegex(), "")
            outputStr = calculator.calc(outputStr)
        }
        else */
        if (inputStr.isEmpty()) {
            outputStr = inputStr
        }
        if (inputStr.isNotEmpty() && inputStr[inputStr.length - 1] !in wkOperations) {
            outputStr = calculator.calc(inputStr)
        }
        return outputStr
    }

    private fun checkDot(inputStr: String): Boolean {
        for (i in inputStr.length - 2 downTo 0) {
            if (inputStr[i] in wkOperations) {
                break
            }
            if (inputStr[i] == '.') {
                return true
            }
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val historyTextView: TextView = findViewById(R.id.textView4)

        var max_string = 15
        var count = 0

        val buttonOne: Button = findViewById(R.id.button_one)
        buttonOne.setOnClickListener {
            if (isActive) {
                inputStr += "1"
                subInputStr += "1"
                textView.text = subInputStr
                historyTextView.text = printRes(inputStr)

            }
            else {
                inputStr += "1"
                textView.text = inputStr
                historyTextView.text = printRes(inputStr)
            }
            count++
            if (count>max_string){
                var toast_max_string = Toast.makeText(getApplicationContext(), "Невозможно ввести более 15 цифр.", Toast.LENGTH_SHORT)
                toast_max_string.show()
            }
        }

        val buttonTwo: Button = findViewById(R.id.button_two)
        buttonTwo.setOnClickListener {
            if (isActive) {
                inputStr += "2"
                subInputStr += "2"
                textView.text = subInputStr
                historyTextView.text = printRes(inputStr)
            }
            else {
                inputStr += "2"
                textView.text = inputStr
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonThree: Button = findViewById(R.id.button_three)
        buttonThree.setOnClickListener {
            if (isActive) {
                inputStr += "3"
                subInputStr += "3"
                textView.text = subInputStr
                historyTextView.text = printRes(inputStr)
            }
            else {
                inputStr += "3"
                textView.text = inputStr
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonFour: Button = findViewById(R.id.button_four)
        buttonFour.setOnClickListener {
            if (isActive) {
                inputStr += "4"
                subInputStr += "4"
                textView.text = subInputStr
                historyTextView.text = printRes(inputStr)
            }
            else {
                inputStr += "4"
                textView.text = inputStr
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonFive: Button = findViewById(R.id.button_five)
        buttonFive.setOnClickListener {
            if (isActive) {
                inputStr += "5"
                subInputStr += "5"
                textView.text = subInputStr
                historyTextView.text = printRes(inputStr)
            }
            else {
                inputStr += "5"
                textView.text = inputStr
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonSix: Button = findViewById(R.id.button_six)
        buttonSix.setOnClickListener {
            if (isActive) {
                inputStr += "6"
                subInputStr += "6"
                textView.text = subInputStr
                historyTextView.text = printRes(inputStr)
            }
            else {
                inputStr += "6"
                textView.text = inputStr
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonSeven: Button = findViewById(R.id.button_seven)
        buttonSeven.setOnClickListener {
            if (isActive) {
                inputStr += "7"
                subInputStr += "7"
                textView.text = subInputStr
                historyTextView.text = printRes(inputStr)
            }
            else {
                inputStr += "7"
                textView.text = inputStr
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonEight: Button = findViewById(R.id.button_eight)
        buttonEight.setOnClickListener {
            if (isActive) {
                inputStr += "8"
                subInputStr += "8"
                textView.text = subInputStr
                historyTextView.text = printRes(inputStr)
            }
            else {
                inputStr += "8"
                textView.text = inputStr
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonNine: Button = findViewById(R.id.button_nine)
        buttonNine.setOnClickListener {
            if (isActive) {
                inputStr += "9"
                subInputStr += "9"
                textView.text = subInputStr
                historyTextView.text = printRes(inputStr)
            }
            else {
                inputStr += "9"
                textView.text = inputStr
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonZero: Button = findViewById(R.id.button13)
        buttonZero.setOnClickListener {
            if (isActive) {
                inputStr += "0"
                subInputStr += "0"
                textView.text = subInputStr
                historyTextView.text = printRes(inputStr)
            }
            else {
                inputStr += "0"
                textView.text = inputStr
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonPlus: Button = findViewById(R.id.button11)
        buttonPlus.setOnClickListener {
            if (inputStr.length == 0)
                textView.text = inputStr
            else if (inputStr[inputStr.length - 1] !in operations) {
                if (isActive) {
                    inputStr += "+"
                    subInputStr += "+"
                    textView.text = subInputStr
                    historyTextView.text = printRes(inputStr)
                }
                else {
                    inputStr += "+"
                    textView.text = inputStr
                    historyTextView.text = printRes(inputStr)
                }
            }
        }

        val buttonMinus: Button = findViewById(R.id.button23)
        buttonMinus.setOnClickListener {
            if (inputStr.length == 0) {
                textView.text = inputStr
            }
            else if (inputStr[inputStr.length - 1] !in operations) {
                if (isActive) {
                    inputStr += "-"
                    subInputStr += "-"
                    textView.text = subInputStr
                    historyTextView.text = printRes(inputStr)
                }
                else {
                    inputStr += "-"
                    textView.text = inputStr
                    historyTextView.text = printRes(inputStr)
                }
            }
        }

        val buttonMultiply: Button = findViewById(R.id.button22)
        buttonMultiply.setOnClickListener {
            if (inputStr.length == 0)
                textView.text = inputStr
            else if (inputStr[inputStr.length - 1] !in operations) {
                if (isActive) {
                    inputStr += "*"
                    subInputStr += "*"
                    textView.text = subInputStr
                    historyTextView.text = printRes(inputStr)
                }
                else {
                    inputStr += "*"
                    textView.text = inputStr
                    historyTextView.text = printRes(inputStr)
                }
            }
        }

        val buttonDivide: Button = findViewById(R.id.button9)
        buttonDivide.setOnClickListener {
            if (inputStr.length == 0)
                textView.text = inputStr
            else if (inputStr[inputStr.length - 1] !in operations) {
                if (isActive) {
                    inputStr += "/"
                    subInputStr += "/"
                    textView.text = subInputStr
                    historyTextView.text = printRes(inputStr)
                }
                else {
                    inputStr += "/"
                    textView.text = inputStr
                    historyTextView.text = printRes(inputStr)
                }
            }
        }

        val buttonDelete: Button = findViewById(R.id.button10)
        buttonDelete.setOnClickListener {
            /*if (inputStr.isEmpty()) {
                isActive = false
                textView.text = ""
                historyTextView.text = ""
            }*/
            if (inputStr[inputStr.length - 1] == ')') {
                isActive = true
            }
            if (isActive) {
                inputStr = inputStr.replaceFirst(".$".toRegex(), "")
                subInputStr = subInputStr.replaceFirst(".$".toRegex(), "")
                textView.text = subInputStr
                historyTextView.text = printRes(inputStr)
            }
            else {
                inputStr = inputStr.replaceFirst(".$".toRegex(), "")
                textView.text = inputStr
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonClear: Button = findViewById(R.id.button15)
        buttonClear.setOnClickListener {
            if (isActive) {
                isActive = false
                subInputStr = ""
            }
            inputStr = ""
            textView.text = inputStr
            historyTextView.text = ""
        }

        val buttonLeftBracket: Button = findViewById(R.id.button5)
        buttonLeftBracket.setOnClickListener {
                isActive = true
                subInputStr = inputStr
                subInputStr += "("
                textView.text = subInputStr
                historyTextView.text = printRes(inputStr)
        }

        val buttonRightBracket: Button = findViewById(R.id.button7)
        buttonRightBracket.setOnClickListener {
            if (inputStr.isEmpty()) {
                textView.text = inputStr
            }
            else {
                isActive = false
                subInputStr += ")"
                inputStr = subInputStr
                textView.text = subInputStr
                historyTextView.text = printRes(subInputStr)
            }
        }

        val buttonDot: Button = findViewById(R.id.button4)
        buttonDot.setOnClickListener {
            if (inputStr.length == 0)
                textView.text = inputStr
            else if (inputStr[inputStr.length - 1] !in operations) {
                if (isActive) {
                    if (!checkDot(inputStr)) {
                        inputStr += "."
                        subInputStr += "."
                        textView.text = subInputStr
                        historyTextView.text = printRes(inputStr)
                    }
                    else {
                        textView.text = subInputStr
                        historyTextView.text = printRes(inputStr)
                    }
                }
                else {
                    if (!checkDot(inputStr)) {
                        inputStr += "."
                        textView.text = inputStr
                        historyTextView.text = printRes(inputStr)
                    }
                    else {
                        textView.text = inputStr
                        historyTextView.text = printRes(inputStr)
                    }
                }
            }
        }

        val buttonIs: Button = findViewById(R.id.button12)
        buttonIs.setOnClickListener {
            if (inputStr.isEmpty())
                textView.text = inputStr
            else if (inputStr[inputStr.length - 1] !in operations) {
                if (isActive) {
                    isActive = false
                }
                inputStr = printRes(inputStr)
                textView.text = inputStr
            }
        }
    }
}