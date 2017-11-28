package main
import java.util.Random

class StringAlgorithms(title: String, author: String, version: String, description: String): Algorithms(title,author,version,description)  {

    var inputText : String
    var patternCypher : String
    var expression : String
    var letters : String

    init {
        this.inputText = ""
        this.patternCypher = ""
        this.expression = ""
        this.letters = ""
    }

    fun setInputeText (input : String){
        this.inputText = input
    }

    fun createPattern() {
        this.letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
       var number = Random().nextInt((25 - 0)) + 0
       // gerando uma cifra aleatoria

        var i = 0..25
        for (a in i){
            if(a+number<=25){
                this.patternCypher = this.patternCypher + this.letters.get(a+number)
            }
            else {
                this.patternCypher = this.patternCypher + this.letters.get(a+number-26)
            }
        }
    }

    fun cesarCypher() : String{
        var cypher = ""
        var i = 0..inputText.length-1
        var i2 = 0..25
        this.letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        createPattern()
        for (a in i){
            for (b in i2){
                if(inputText.get(a)==letters.get(b))
                    cypher = cypher + this.patternCypher.get(b)
            }
            if(inputText.get(a).toString()==" ")
                cypher = cypher + " "
        }
       return cypher
    }

    fun countOcurrences() : String {
        this.letters = "abcdefghijklmnopqrstuvwxyz"
        var size=this.inputText.length
        var i = 0..25
        var i2 = 0..size-1
        var letter : Char
        var numb = 0
        var text = ""
        for(a in i)
        {
            for(b in i2)
            {
                if(letters.get(a)==this.inputText.get(b))
                {
                    numb=numb+1
                }

            }
            if(numb!=0){
                letter=letters[a]
                letter.toString()
                text = text + letter + "$numb"
            }
            numb=0
        }
        return text
    }

    fun cleanInputText() : String{
        this.letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
        var size=this.inputText.length
        var i = 0..size-1
        var i2 = 0..51
        var text = ""
        for (a in i)
        {
            for (b in i2)
            {
                if(letters.get(b)==inputText.get(a))
                {
                    text = text + inputText.get(a)
                }
            }
        }
        return text
    }

    fun scheduleExpression() : String{
        var text = ""
        var size=this.expression.length
        var i = 0..size-1
        var check = false
        var period = ""
        for(a in i)
        {
            if(expression.get(a).toString()=="M")
            {
                check=true
                period = "M"

            }
            if(expression.get(a).toString()=="T")
            {
                check=true
                period = "T"
            }
            if(expression.get(a).toString()=="N")
            {
                check=true
                period = "N"
            }
            if(check==false)
            {
                if(expression.get(a).toString()=="2")
                {
                    text = text + "segunda-feira, "
                }
                if(expression.get(a).toString()=="3")
                {
                    text = text + "terça-feira, "
                }
                if(expression.get(a).toString()=="4")
                {
                    text = text + "quarta-feira, "
                }
                if(expression.get(a).toString()=="5")
                {
                    text = text + "quinta-feira, "
                }
                if(expression.get(a).toString()=="6")
                {
                    text = text + "sexta-feira, "
                }
                if(expression.get(a).toString()=="7")
                {
                    text = text + "sábado, "
                }
            }
            if(check==true && period== "M")
            {
                if(expression.get(a).toString()=="1")
                {
                    text = text + "07:55, "
                }
                if(expression.get(a).toString()=="2")
                {
                    text = text + "09:45, "
                }
                if(expression.get(a).toString()=="3")
                {
                    text = text + "10:05, "
                }
                if(expression.get(a).toString()=="4")
                {
                    text = text + "11:10, "
                }
            }
            if(check==true && period== "T")
            {
                if(expression.get(a).toString()=="1")
                {
                    text = text + "13:30, "
                }
                if(expression.get(a).toString()=="2")
                {
                    text = text + "14:25, "
                }
                if(expression.get(a).toString()=="3")
                {
                    text = text + "15:45, "
                }
                if(expression.get(a).toString()=="4")
                {
                    text = text + "16:40, "
                }
                if(expression.get(a).toString()=="5")
                {
                    text = text + "17:40, "
                }
            }
            if(check==true && period== "N")
            {
                if(expression.get(a).toString()=="1")
                {
                    text = text + "19:00, "
                }
                if(expression.get(a).toString()=="2")
                {
                    text = text + "19:50, "
                }
            }
        }
        return text
    }
}