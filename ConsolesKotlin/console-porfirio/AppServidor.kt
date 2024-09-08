package org.example

fun main (){

    val servidor = Servidor()

    println("Digite a CPU do seu servidor: ")
    val CPU: String = readln()

    println("Digite a quantidade de memória do seu servidor: ")
    val memoria: Int = readln().toInt()

    println("Digite se o seu servidor está ligado: ")
    val ligado: Boolean = readln().toBoolean()

    println("Digite o Disco do seu servidor: ")
    val disco: String = readln()

    println("Digite a rede que seu seu servidor está conectado: ")
    val rede: String = readln()

    servidor.CPU = CPU
    servidor.memoria = memoria
    servidor.ligado = ligado
    servidor.disco = disco
    servidor.rede = rede



    while (true) {
        print(
            """------------Menu------------
           1 - Descrever o servidor
           2 - Aumentar a memoria
           3 - Remover memoria
           4 - Ver historico de ação
           5 - Sair
         Insira uma opção: """.trimIndent()
        )
        var resposta = readln().toInt()

        when (resposta) {
            1 -> println(servidor.descrever())
            2 -> println(servidor.aumentarMemoria())
            3 -> println(servidor.retirarMemoria())
            4 -> println(servidor.historicoDeAcao)
            5 -> break
            else -> println("Opção inválida!")
        }
    }
}

