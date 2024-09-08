fun main() {
    print(
        """---------- Monitoramento de HardWare ----------
        Bem vindo! Registre seu computador e monitore: 
        -> Uso da CPU
        -> Uso da memória RAM
        ---------------------------------------------------
        
        """.trimIndent()
    )

    val maquina1 = Monitoramento()
    maquina1.cadastrarComponentes()

    println("\nMáquina cadastrada com sucesso!")

    while (true) {
        print(
           """------------Menu------------
           1 - Capturar dados
           2 - Exibir dados capturados
           3 - Exibir minha máquina
           4 - Sair
         Insira uma opção: """.trimIndent()
        )
        var resposta = readln().toInt()

        when (resposta) {
            1 -> maquina1.capturarDados()
            2 -> maquina1.exibirDados()
            3 -> maquina1.exibirConfigs()
            4 -> System.exit(0)
            else -> println("Opção inválida!")
        }
    }
    Thread.sleep(2000) // esperando 2 segundos até exibir o menu novament

}


