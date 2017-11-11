package com.fflush.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Variables used
    var op = "*"
    var oldNumber = ""
    var isNewOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonNumberEvent(view: View){
        if (isNewOperation){
            showNumbersText.setText("")
        }
        isNewOperation = false
        val buttonSelected = view as Button
        var buttonClickedNumber: String = showNumbersText.text.toString()
        when(buttonSelected.id){
            buttonNumber0.id -> {
                buttonClickedNumber += "0"
            }
            buttonNumber1.id -> {
                buttonClickedNumber += "1"
            }
            buttonNumber2.id -> {
                buttonClickedNumber += "2"
            }
            buttonNumber3.id -> {
                buttonClickedNumber += "3"
            }
            buttonNumber4.id -> {
                buttonClickedNumber += "4"
            }
            buttonNumber5.id -> {
                buttonClickedNumber += "5"
            }
            buttonNumber6.id -> {
                buttonClickedNumber += "6"
            }
            buttonNumber7.id -> {
                buttonClickedNumber += "7"
            }
            buttonNumber8.id -> {
                buttonClickedNumber += "8"
            }
            buttonNumber9.id -> {
                buttonClickedNumber += "9"
            }
            buttonDot.id -> {
                if(!buttonClickedNumber.contains(".")) {
                    buttonClickedNumber += "."
                }
            }
            buttonPosNeg.id -> {
                if(!buttonClickedNumber.contains("-")) {
                    buttonClickedNumber = "-$buttonClickedNumber"
                }
            }
        }
        showNumbersText.setText(buttonClickedNumber)
    }

    fun buttonOperationEvent (view: View){
        val buttonSelected = view as Button
        when(buttonSelected.id){
            buttonProd.id -> {
                op="*"
            }
            buttonDiv.id -> {
                op="/"
            }
            buttonSum.id -> {
                op="+"
            }
            buttonMin.id -> {
                op="-"
            }
        }
        oldNumber = showNumbersText.text.toString()
        isNewOperation = true
    }

    fun buttonEqualsEvent(view: View){
        val newNumber = showNumbersText.text.toString()
        var finalNumber: Double?= null
        when(op){
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()

            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
        }
        showNumbersText.setText(finalNumber.toString())
        isNewOperation = true
    }
}
