package com.projec.myapplication

class Calculator {
    private val operations = "*/+-"

    private fun checkExpression(expression:String) : Boolean{
        for (i in expression.indices)
            if (expression[i] in operations)
                return true
        return false
    }


    private fun priorityOp(expression: String): Char?{
        if ('(' in expression)
            return '('

        var operation: Char? = null
        val operationsFp = "*/"
        val operationsSp = "+-"
        for (c in expression){
            if (c in operationsFp){
                operation = c
                break
            }
            if (c in operationsSp && operation == null)
                operation = c
        }

        return operation
    }


    private fun indexClosingBracket(expression: String, indexOpenBracket: Int): Int{
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


    private fun indicesSubstring(expression: String, indexOperation: Int): IntArray{
        val indices: IntArray = intArrayOf(0, 0)

        for (j in (indexOperation - 1) downTo 0){
            if (expression[j] in operations) {

                indices[0] = j + 1
                break
            }
            indices[0] = j
        }

        for (j in (indexOperation + 1) until expression.length) {
            if (expression[j] in operations) {
                indices[1] = j - 1
                break
            }
            indices[1] = expression.length - 1
        }

        return indices
    }

    private fun replaceMinus(expression: String): String{
        var result = expression
        if (result[0] == '-')
            result = result.replaceFirst('-', 'n')
        val chars = result.toCharArray()
        for (i in 0..chars.lastIndex){
            if (chars[i] == '(' && chars[i + 1] == '-')
                chars[i + 1] = 'n'
        }
        result = String(chars)
        return result
    }

    private fun formatAnswer(answer: String): String{
        if ('.' !in answer)
            return answer.replace('n', '-')
        var list = (answer.split('.')).toTypedArray()
        list[0] = list[0].replace('n', '-')
        if (list[1] == "0")
            return list[0]
        else
            return answer.replace('n', '-')
    }



    fun calc(expression: String) : String{
        var resultExpression = replaceMinus(expression)
        while (checkExpression(resultExpression)){
            val operation: Char = priorityOp(resultExpression) ?: break

            val iOp = resultExpression.indexOf(operation)

            if (resultExpression[iOp] == operation){
                if (operation == '('){
                    var subexpression = resultExpression.substring(iOp + 1, indexClosingBracket(resultExpression, iOp))

                    subexpression = calc(subexpression)
                    resultExpression = resultExpression.replaceFirst(resultExpression.substring(iOp, indexClosingBracket(resultExpression, iOp) + 1), subexpression)
                }

                else{

                    val indicesSub = indicesSubstring(resultExpression, iOp)

                    val subexpression = resultExpression.substring(indicesSub[0], indicesSub[1] + 1)
                    val numInSub = (subexpression.split(operation)).toTypedArray()
                    for (i in 0..numInSub.lastIndex)
                        numInSub[i] = numInSub[i].replace('n', '-')

                    var subexpRes = "0"
                    when (operation){
                        '*' -> subexpRes = (numInSub[0].toFloat() * numInSub[1].toFloat()).toString()
                        '/' -> subexpRes = (numInSub[0].toFloat() / numInSub[1].toFloat()).toString()
                        '+' -> subexpRes = (numInSub[0].toFloat() + numInSub[1].toFloat()).toString()
                        '-' -> subexpRes = (numInSub[0].toFloat() - numInSub[1].toFloat()).toString()
                    }

                    subexpRes = subexpRes.replace('-', 'n')
                    resultExpression = resultExpression.replaceFirst(subexpression, subexpRes)
                }
            }

        }
        return resultExpression
    }

    fun formatCalc(expression: String): String{
        return formatAnswer(calc(expression))
    }

}