package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.simplecalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private var first = ""
    private var second = ""
    private var operator = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setNumberClick(binding.btn0, "0")
        setNumberClick(binding.btn1, "1")
        setNumberClick(binding.btn2, "2")
        setNumberClick(binding.btn3, "3")
        setNumberClick(binding.btn4, "4")
        setNumberClick(binding.btn5, "5")
        setNumberClick(binding.btn6, "6")
        setNumberClick(binding.btn7, "7")
        setNumberClick(binding.btn8, "8")
        setNumberClick(binding.btn9, "9")

        setOperator(binding.btnAdd, "+")
        setOperator(binding.btnSub, "-")
        setOperator(binding.btnMul, "*")
        setOperator(binding.btnDiv, "/")

        binding.btnEqual.setOnClickListener {
            calculate()
        }

        binding.btnAC.setOnClickListener {
            first = ""
            second = ""
            operator = ""
            binding.tvInput.text = ""
            binding.tvResult.text = ""
        }




        }
    private fun setNumberClick(button: android.widget.Button, value: String){
        button.setOnClickListener {
            if (operator.isEmpty()){
                first+=value
                binding.tvInput.text = first
            }else{
                second += value
                binding.tvInput.text = "$first $operator $second"
            }
        }
    }

    private fun setOperator(button: android.widget.Button, op: String){
        button.setOnClickListener {
            if (first.isNotEmpty()){
                operator = op
                binding.tvInput.text = "$first $operator"
            }
        }
    }

    private fun calculate(){
        if (first.isEmpty() || second.isEmpty()) return

        val a = first.toDouble()
        val b = second.toDouble()
        val result = when(operator){
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> a / b
            else -> 0.0
        }

        binding.tvResult.text = result.toString()




    }

}