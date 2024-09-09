fun main() {

    println("Qual é o fabricante do seu servidor?")
    var fabricanteUsuario = readln()
    println("Qual é o Sistema Operacional que seu servidor está utilizando? ")
    var soUsuario = readln()
    println("Aonde seu servidor está localizado?")
    var localizacaoServidorUsuario = readln()
    println("Quais aplicações estão instaladas em seu servidor?")
    var aplicacoesInstaladasUsuario = readln()

    var servidorUsuario = Servidor(soUsuario, fabricanteUsuario, localizacaoServidorUsuario, aplicacoesInstaladasUsuario)

    while (true){

        println("1: Monitorar CPU")
        println("2: Monitorar Memória")
        println("3: Monitorar temperatura")
        println("4: Sair")
        var opcaoUsuario = readln().toInt()

        when (opcaoUsuario){

            1-> {
                println("Digite a porcentagem de uso de sua CPU")
                var porcentagemUsoCpuUsuario = readln().toDouble()
                println(servidorUsuario.descrever())
                Thread.sleep(8000 )
                servidorUsuario.validarCPU(porcentagemUsoCpuUsuario)
                println(servidorUsuario.validarCPU(porcentagemUsoCpuUsuario))
            }

            2-> {
                println("Digite a porcentagem de uso da sua memória")
                var porcentagemUsoMemoriaUsuario = readln().toDouble()
                println(servidorUsuario.descrever())
                Thread.sleep(8000 )
                servidorUsuario.validarMemoria(porcentagemUsoMemoriaUsuario)
                println(servidorUsuario.validarMemoria(porcentagemUsoMemoriaUsuario))
            }

            3 -> {
                println("Digite a temperatura de seu servidor")
                var temperaturaServidorUsuario = readln().toDouble()
                println(servidorUsuario.descrever())
                Thread.sleep(8000 )
                servidorUsuario.validarTemperatura(temperaturaServidorUsuario)
                println(servidorUsuario.validarTemperatura(temperaturaServidorUsuario))
            }

            4 -> break
            else -> {
                println("Opção inválida")
            }



        }




    }


}