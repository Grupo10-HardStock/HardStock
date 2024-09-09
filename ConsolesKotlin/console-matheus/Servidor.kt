class Servidor(
    var sistemaOperacional: String = "",
    var fabricante: String = "",
    var localizacao: String = "",
    var aplicacoesInstaladas: String = "",
    var riscos: Int = 0

) {
    val alertasAtivosTemperatura = mutableListOf<Double>()
    val alertasAtivosCpu = mutableListOf<Double>()
    val alertasAtivosMemoria = mutableListOf<Double>()



    fun descrever(): String {
        var texto =
            "Estamos monitorando o servidor do fabricante $fabricante, que está localizado em $localizacao. Além disso, possue o $sistemaOperacional de Sistema Operacional e contém $aplicacoesInstaladas de aplicações instaladas."
        return texto
    }

    fun validarTemperatura(temperaturaServidorUsuario: Double):String{
    var textoTemperatura = "Temperatura válida"
    if (temperaturaServidorUsuario <= 10){
        riscos++
        alertasAtivosTemperatura.add(temperaturaServidorUsuario)
         textoTemperatura = "Temperatura inválida. Contém risco "
    }

    if (temperaturaServidorUsuario >= 32){
    riscos++
    alertasAtivosTemperatura.add(temperaturaServidorUsuario)
         textoTemperatura = "Temperatura inválida. Contém risco "
    }
        return textoTemperatura
    }

    fun validarCPU(porcentagemUsoCpuUsuario: Double): String{
        var textoCpu = "Uso de CPU válido"
        if (porcentagemUsoCpuUsuario in 80.00..100.00){
            riscos++
            alertasAtivosCpu.add(porcentagemUsoCpuUsuario)
            textoCpu = "Uso de CPU crítico. Contém risco "
        }

        return textoCpu
    }

    fun validarMemoria(porcentagemUsoMemoriaUsuario: Double):String{

        var textoMemoria = "Uso da Memória válido"
        if (porcentagemUsoMemoriaUsuario in 80.00..100.00){
            riscos++
            alertasAtivosMemoria.add(porcentagemUsoMemoriaUsuario)
             textoMemoria = "Uso de CPU crítico. Contém risco "
        }

        return textoMemoria

    }


    }



