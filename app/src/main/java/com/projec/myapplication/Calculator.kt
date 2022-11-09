package com.projec.myapplication

import kotlin.math.exp

class Calculator {
    val operations = "*/+-"
    private fun priorityOp(math_expression: String): Char?{
        if ('(' in math_expression)
            return '('

        var priorityOp: Char? = null
        val operationsFp = "*/"
        val operationsSp = "+-"
        for (c in math_expression){
            if (c in operationsFp){
                priorityOp = c
                break
            }
            if (c in operationsSp && priorityOp == null)
                priorityOp = c
        }

        return priorityOp
    }

    fun indexClosingBracket(expression: String, indexOpenBracket: Int): Int{
        var k_brackets = 0
        for (i in indexOpenBracket until expression.length){
            if (expression[i] == '(')
                k_brackets++
            if (expression[i] == ')')
                k_brackets--
            if (k_brackets == 0)
                return i
        }
        return 0
    }

    private fun formatAnswer(answer: String): String{
        val list = answer.split('.')
        if (list[1] == "0")
            return list[0]
        else
            return answer
    }

    fun calc(in_expression: String): String{
        var str = in_expression

        while(true){
            val operation: Char = priorityOp(str) ?: break

            for (i in str.indices){
                if (str[i] == operation) {
                    if (operation == '('){
                        val expression = str.substring(i + 1, indexClosingBracket(str, i))
                        var strRes = calc(expression)
                        str = str.replaceFirst(str.substring(i, indexClosingBracket(str, i) + 1), strRes)
                        break
                    }
                    else{
                        var iLVal  = 0
                        var iRVal = 0
                        for (j in (i - 1) downTo 0) {
                            if (str[j] in operations) {

                                iLVal = j + 1
                                break
                            }
                            iLVal = j
                        }
                        for (j in (i + 1) until str.length) {
                            if (str[j] in operations) {
                                iRVal = j - 1
                                break
                            }
                            iRVal = str.length - 1
                        }

                        val expression = str.substring(iLVal, iRVal + 1)
                        val list = expression.split(operation)
                        var strRes = "0"

                        when(operation){
                            '*' -> strRes = (list[0].toFloat() * list[1].toFloat()).toString()
                            '/' -> strRes = (list[0].toFloat() / list[1].toFloat()).toString()
                            '+' -> strRes = (list[0].toFloat() + list[1].toFloat()).toString()
                            '-' -> strRes = (list[0].toFloat() - list[1].toFloat()).toString()
                        }
                        str = str.replaceFirst(expression, strRes)
                        break
                    }

                }
            }
        }

        return formatAnswer(str)
    }
}

fun main(args: Array<String>){
    val calc = Calculator()
    print(calc.calc("(2+2+(4/2))*(3+3)"))
}