package main

import java.lang.Math.pow


open class NumericAlgorithms(title : String, author : String, version : String, description : String) : Algorithms(title, author,version,description){

    val map : String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"


    fun shortenerEncode(inputNumber : Int ) : String{

        var inputNumber : Int = inputNumber
        var fim = StringBuilder()

        while (inputNumber >  0 ){

            var posicao =  inputNumber%62
            fim.append(map[posicao])
            inputNumber = inputNumber/62

        }
        return fim.toString().reversed()

    }

    fun shortenerDecode( inputText : String ) : Int{

        var inputText : String = inputText.reversed()
        var fim : Int = 0
        var percorre : Int = 0
        var tamanho : Int = inputText.length
        var tamanhomap: Int = map.length
        var percorremap : Int = 0



        while ( percorre < tamanho ){
            percorremap = 0

            while ( percorremap < tamanhomap){

                if(inputText[percorre] == map[percorremap] )
                    fim = (fim + pow(62.0 ,percorre.toDouble())*percorremap).toInt()

                percorremap ++

            }
            percorre ++


        }

        return fim
    }



    fun generateNumberSequence(inputText: String): Int {

        var texto: String = inputText
        var T: Int = inputText.hashCode()
        val M = pow(2.0, 32.0)- 1
        return ((T and 0x7fffffff) % M).toInt()

        //return inputText.hashCode()
    }


}




