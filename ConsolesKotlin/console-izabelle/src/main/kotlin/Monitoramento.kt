import kotlin.random.Random
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Monitoramento (
    var CPU: String = "",
    var RAM: Int = 0
) {
    val listaDadosCPU = mutableListOf<Int>()
    val listaDadosRAM = mutableListOf<Int>()

    val listaDadosAltosCPU = mutableListOf<Int>()
    val listaDadosAltosRAM = mutableListOf<Int>()
    val horarioDAcpu = mutableListOf<String>()
    val horarioDAram = mutableListOf<String>()

    val formatadorDtHr = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")


    fun cadastrarComponentes() {
        print("Insira o modelo do seu processador: ")
        var cadastrarCPU = readln()
        CPU = cadastrarCPU

        print("Insira a quantidade de memória RAM: ")
        var cadastrarRAM = readln().toInt()
        RAM = cadastrarRAM
    }

    fun capturarDados() {
        println("Capturando dados....")
        for (i in 1..10) {
            val numAleatorioCPU = Random.nextInt(9, 100)
            val numAleatorioRAM = Random.nextInt(9, 100)
            listaDadosCPU.add(numAleatorioCPU)
            listaDadosRAM.add(numAleatorioRAM)

            if (numAleatorioCPU >= 85 || numAleatorioRAM >= 85) {

                //formatando a data e hora atuais para relacionar aos dados elevados capturados
                val dtAtual = LocalDateTime.now()
                val dtHoraFormatada = dtAtual.format(formatadorDtHr)

                if (numAleatorioCPU >= 85) {
                    listaDadosAltosCPU.add(numAleatorioCPU)
                    horarioDAcpu.add(dtHoraFormatada)
                }
                if (numAleatorioRAM >= 85) {
                    listaDadosAltosRAM.add(numAleatorioRAM)
                    horarioDAram.add(dtHoraFormatada)
                }
            }
            Thread.sleep(1000)
        }
        println("Dados Capturados com sucesso!")
    }

    fun exibirDados() {
        var relatorioCPU = "\n"
        var relatorioRAM = "\n"

        for (i in 0 until listaDadosAltosCPU.size) {
            relatorioCPU += "-> Data: ${horarioDAcpu[i]} Uso da CPU: ${listaDadosAltosCPU[i]}%\n"
        }

        for (i in 0 until listaDadosAltosRAM.size) {
            relatorioRAM += "-> Data: ${horarioDAram[i]} Uso da CPU: ${listaDadosAltosRAM[i]}%\n"
        }

        println("""
        Dados capturados da CPU (porcentagem de uso): $listaDadosCPU
             
        Dados capturados da RAM (porcentagem de uso): $listaDadosRAM
             
        Dados acima do comum da CPU: $relatorioCPU
             
        Dados acima do comum da RAM: $relatorioRAM
        """.trimIndent())
    }

    fun exibirConfigs() {
        println("""
            
            ESPECIFICAÇÕES DA MÁQUINA
            CPU: $CPU
            RAM: $RAM
            """.trimIndent())
    }
}