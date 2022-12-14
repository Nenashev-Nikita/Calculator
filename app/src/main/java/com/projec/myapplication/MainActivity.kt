package com.projec.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val MAX_LENGTH: Int = 15

    private var inputStr: String = ""
    private var subInputStr: String = ""
    private var outputStr: String = ""
    private val operations = "*/+-."
    private val wkOperations = "*/+-"
    private var numberOfBrackets = 0
    private var isActive: Boolean = false

    private val calculator: Calculator = Calculator()

    private fun isExpression(inputStr: String): Boolean {
        var border = if (numberOfBrackets != 0) {
            numberOfBrackets + 1
        }
        else {
            1
        }
        /*if (inputStr.isNotEmpty() && (inputStr[border - 1] == '(')*//* || inputStr[1] == '(')*//*)
            border++*/
        for (i in border until inputStr.length) {
            if (inputStr[i] in wkOperations && i != inputStr.length - 1) {
                return true
            }
        }

        if (inputStr.isEmpty() || inputStr[0] == '-' || (inputStr[0] == '(' && inputStr[1] == '-')) {
            return false
        }
        return false
    }

    private fun addStr(inputStr: String): String {
        outputStr = if (inputStr[inputStr.length - 1] in wkOperations) {
            inputStr.replaceFirst(".$".toRegex(), "")
        }
        else {
            inputStr
        }
        if (isActive && outputStr[outputStr.length - 1] != '(') {
            outputStr += ")"
            return outputStr
        }
        else if (isActive && outputStr[outputStr.length - 1] == '(') {
            outputStr = outputStr.replaceFirst(".$".toRegex(), "")
            return outputStr
        }
        return outputStr
    }

    private fun printRes(inputStr: String): String {
        subInputStr = inputStr
        if (numberOfBrackets != 0) {
            for (i in 1..numberOfBrackets) {
                subInputStr = addStr(subInputStr)
            }
        }
        if (!isExpression(subInputStr)) {
            return ""
        }
        if (subInputStr.isNotEmpty() && subInputStr[subInputStr.length - 1] in wkOperations) {
            outputStr = subInputStr.replaceFirst(".$".toRegex(), "")
            outputStr = calculator.formatCalc(outputStr)
            return outputStr
        }
        if (subInputStr.isEmpty()) {
            outputStr = inputStr
        }
        if (subInputStr.isNotEmpty() && subInputStr[subInputStr.length - 1] !in wkOperations) {
            outputStr = calculator.formatCalc(subInputStr)
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

    private fun span(str: String): Spannable {
        val text: Spannable = SpannableString(str)
        for (i in 0 until str.length){
            if (str[i] in wkOperations){
                text.setSpan(AbsoluteSizeSpan(100), i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                text.setSpan(ForegroundColorSpan(Color.rgb(44, 122, 185)),  i, i + 1,  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            }

        }
        return text
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView4)
        val historyTextView: TextView = findViewById(R.id.textView)

        val toast = Toast.makeText(applicationContext, "???????????? ???? ??????????????????", Toast.LENGTH_SHORT)

        val buttonOne: Button = findViewById(R.id.button_one)
        buttonOne.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isNotEmpty() && inputStr[inputStr.length - 1] == ')')
                return@setOnClickListener

            inputStr += "1"
            textView.text = span(inputStr)
            historyTextView.text = printRes(inputStr)

        }

        val buttonTwo: Button = findViewById(R.id.button_two)
        buttonTwo.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isNotEmpty() && inputStr[inputStr.length - 1] == ')')
                return@setOnClickListener

            inputStr += "2"
            textView.text = span(inputStr)
            historyTextView.text = printRes(inputStr)

        }

        val buttonThree: Button = findViewById(R.id.button_three)
        buttonThree.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isNotEmpty() && inputStr[inputStr.length - 1] == ')')
                return@setOnClickListener

            inputStr += "3"
            textView.text = span(inputStr)
            historyTextView.text = printRes(inputStr)

        }

        val buttonFour: Button = findViewById(R.id.button_four)
        buttonFour.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isNotEmpty() && inputStr[inputStr.length - 1] == ')')
                return@setOnClickListener

            inputStr += "4"
            textView.text = span(inputStr)
            historyTextView.text = printRes(inputStr)

        }

        val buttonFive: Button = findViewById(R.id.button_five)
        buttonFive.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isNotEmpty() && inputStr[inputStr.length - 1] == ')')
                return@setOnClickListener

            inputStr += "5"
            textView.text = span(inputStr)
            historyTextView.text = printRes(inputStr)

        }

        val buttonSix: Button = findViewById(R.id.button_six)
        buttonSix.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isNotEmpty() && inputStr[inputStr.length - 1] == ')')
                return@setOnClickListener

            inputStr += "6"
            textView.text = span(inputStr)
            historyTextView.text = printRes(inputStr)

        }

        val buttonSeven: Button = findViewById(R.id.button_seven)
        buttonSeven.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isNotEmpty() && inputStr[inputStr.length - 1] == ')')
                return@setOnClickListener

            inputStr += "7"
            textView.text = span(inputStr)
            historyTextView.text = printRes(inputStr)

        }

        val buttonEight: Button = findViewById(R.id.button_eight)
        buttonEight.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isNotEmpty() && inputStr[inputStr.length - 1] == ')')
                return@setOnClickListener

            inputStr += "8"
            textView.text = span(inputStr)
            historyTextView.text = printRes(inputStr)

        }

        val buttonNine: Button = findViewById(R.id.button_nine)
        buttonNine.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isNotEmpty() && inputStr[inputStr.length - 1] == ')')
                return@setOnClickListener

            inputStr += "9"
            textView.text = span(inputStr)
            historyTextView.text = printRes(inputStr)

        }

        val buttonZero: Button = findViewById(R.id.button13)
        buttonZero.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isNotEmpty() && inputStr[inputStr.length - 1] == ')')
                return@setOnClickListener

            inputStr += "0"
            textView.text = span(inputStr)
            historyTextView.text = printRes(inputStr)

        }

        val buttonPlus: Button = findViewById(R.id.button11)
        buttonPlus.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isEmpty())
                textView.text = span(inputStr)
            else if (inputStr[inputStr.length - 1] !in operations  && inputStr[inputStr.length - 1]  != '(') {
                inputStr += "+"
                textView.text = span(inputStr)
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonMinus: Button = findViewById(R.id.button23)
        buttonMinus.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isEmpty()) {
                inputStr += "-"
                textView.text = span(inputStr)
                historyTextView.text = ""
            }
            else if (inputStr[inputStr.length - 1] !in operations) {
                inputStr += "-"
                textView.text = span(inputStr)
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonMultiply: Button = findViewById(R.id.button22)
        buttonMultiply.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isEmpty())
                textView.text = span(inputStr)
            else if (inputStr[inputStr.length - 1] !in operations  && inputStr[inputStr.length - 1] != '(') {
                inputStr += "*"
                textView.text = span(inputStr)
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonDivide: Button = findViewById(R.id.button9)
        buttonDivide.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isEmpty())
                textView.text = span(inputStr)
            else if (inputStr[inputStr.length - 1] !in operations && inputStr[inputStr.length - 1] != '(') {
                inputStr += "/"
                textView.text = span(inputStr)
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonDelete: Button = findViewById(R.id.button10)
        buttonDelete.setOnClickListener {
            if (inputStr.isEmpty()) {
                return@setOnClickListener
            }
            if (inputStr.length == 1) {
                isActive = false
                numberOfBrackets = 0
                inputStr = ""
                textView.text = span(inputStr)
                historyTextView.text = ""
                return@setOnClickListener
            }
            if (inputStr[inputStr.length - 1] == ')') {
                isActive = true
                numberOfBrackets++
                inputStr = inputStr.replaceFirst(".$".toRegex(), "")
                textView.text = span(inputStr)
                historyTextView.text = printRes(inputStr)
                return@setOnClickListener
            }

            if (inputStr[inputStr.length - 1] == '(') {
                if (numberOfBrackets == 1) {
                    isActive = false
                }
                numberOfBrackets--
                inputStr = inputStr.replaceFirst(".$".toRegex(), "")
                textView.text = span(inputStr)
                historyTextView.text = printRes(inputStr)
                return@setOnClickListener
            }

            inputStr = inputStr.replaceFirst(".$".toRegex(), "")
            textView.text = span(inputStr)
            historyTextView.text = printRes(inputStr)
        }

        val buttonClear: Button = findViewById(R.id.button15)
        buttonClear.setOnClickListener {
            if (isActive) {
                isActive = false
                numberOfBrackets = 0
                subInputStr = ""
            }
            inputStr = ""
            textView.text = span(inputStr)
            historyTextView.text = ""
        }

        val buttonLeftBracket: Button = findViewById(R.id.button5)
        buttonLeftBracket.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isNotEmpty() && (inputStr[inputStr.length - 1] == ')' /*|| isActive*/ || inputStr[inputStr.length - 1] in "1234567890.")) {
                return@setOnClickListener
            }

            if (numberOfBrackets == 0) {
                isActive = true
            }
            numberOfBrackets++
            inputStr += "("
            textView.text = span(inputStr)
            historyTextView.text = printRes(inputStr)
        }

        val buttonRightBracket: Button = findViewById(R.id.button7)
        buttonRightBracket.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isEmpty()) {
                return@setOnClickListener
            }
            else if (inputStr[inputStr.length - 1] == '(' || !isActive || inputStr[inputStr.length - 1] in operations) {
                return@setOnClickListener
            }
            else {
                if (numberOfBrackets == 1) {
                    isActive = false
                }
                numberOfBrackets--
                inputStr += ")"
                textView.text = span(inputStr)
                historyTextView.text = printRes(inputStr)
            }
        }

        val buttonDot: Button = findViewById(R.id.button4)
        buttonDot.setOnClickListener {
            if (inputStr.length == MAX_LENGTH) {
                toast.show()
                return@setOnClickListener
            }

            if (inputStr.isEmpty() || inputStr[inputStr.length - 1] in "()")
                textView.text = span(inputStr)
            else if (inputStr[inputStr.length - 1] !in operations) {
                if (!checkDot(inputStr)) {
                    inputStr += "."
                    textView.text = span(inputStr)
                    historyTextView.text = printRes(inputStr)
                }
                else {
                    textView.text = span(inputStr)
                    historyTextView.text = printRes(inputStr)
                }
            }
        }

        val buttonIs: Button = findViewById(R.id.button12)
        buttonIs.setOnClickListener {
            if (inputStr.isEmpty()) {
                textView.text = span(inputStr)
                return@setOnClickListener
            }
            inputStr = printRes(inputStr)
            textView.text = span(inputStr)
            historyTextView.text = ""
        }
    }
}