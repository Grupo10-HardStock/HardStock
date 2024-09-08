package org.example

class Servidor(
    var CPU: String = "",
    var disco: String = "",
    var memoria: Int = 0,
    var rede: String = "",
    var ligado: Boolean = false

) {
    var aumento: Int = 0
    var retirada: Int = 0

    val historicoDeAcao = mutableListOf<String>()

    fun descrever(): String {

        val textoLigado = if (ligado) {
            "ligado"
        } else {
            "desligado"
        }

        return """
            CPU: $CPU
            Memoria base: $memoria
            Memoria adicionada: $aumento
            Memoria retirada: $retirada
            ligado: $textoLigado
            Rede: $rede
            Disco: $disco
       """.trimIndent()
    }

    fun aumentarMemoria(){
        var  memoriaFinal: Int = 0

        if(ligado == false){
            memoriaFinal = memoria + aumento
            println("Voce aumentou: $aumento da sua memória que era de: $memoria ficando no final com: $memoriaFinal")
        }else{
            println("Desligue seu servidor para poder adicionar a memoria")
        }
    }

    fun retirarMemoria(){
        var  memoriaFinal2: Int = 0

        if(ligado == false){
            memoriaFinal2 = memoria - retirada
            println("Voce retirou: $retirada da sua memória que era de: $memoria ficando no final com: $memoriaFinal2")
        }else{
            println("Desligue seu servidor para poder remover a memoria")
        }
    }

    fun ligar() {
        ligado = true
        historicoDeAcao.add("Ligou o servidor.")
    }

    fun desligar(){
        ligado = false
        historicoDeAcao.add("Desligou o servidor.")
    }
}