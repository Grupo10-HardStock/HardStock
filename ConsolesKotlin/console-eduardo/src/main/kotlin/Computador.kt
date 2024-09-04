class Computador(private var teclado: Boolean = false, private var mouse: Boolean = false) {

    private var marca: String = "";
    private var modelo: String = "";
    private var sistemaOperacional: String = "";

    private var nomeProcessador: String = "";
    private var qtdNucleosCpus: Int = 0;
    private var qtdArmazenamento: Int = 0;
    private var qtdDisco: Int = 0;
    private var ligado: Boolean = false;

    private var listaAplicativos = mutableListOf<String>();

    // Metódos
    public fun detalhes(): String {

        return """
            Marca do computador: ${getMarca()}
            Modelo do computador: ${getModelo()}
            Sistema operacional: ${getSistema()}
            Nome do processador: ${getProcessador()}
            Quantidade de Núcleos da CPU: ${getCpus()}
            Quantidade de Armazenamento: ${getArmazenamento()}
            Quantidade de armazenamento no Disco: ${getDisco()}
            Teclado está ligado? ${getTeclado()}
            Mouse está ligado? ${getMouse()}
            O computador está ligado? ${getLigado()}
        """.trimIndent()
    }

    public fun mostrarApps(){
        println("Sua lista de aplicativos é ${getApps()}");
    }

    public fun atualizarSistema(sistema: String) {
        this.setSistema(sistema)
    }

    public fun calcularArmazenamento(usado: Double): Double {
        // poderia dar o return getDisco() - usado para otimizar
        val armazenamentoDisponivel = getDisco() - usado;
        return armazenamentoDisponivel;
    }

    public fun ligar() {
        this.ligado = true
    }

    public fun desligar() {
        this.ligado = false
    }


    // Metódos especiais
    public fun getMarca(): String {
        return this.marca;
    }

    public fun setMarca(marca: String) {
        this.marca = marca;
    }

    public fun getModelo(): String {
        return this.modelo
    }

    public fun setModelo(modelo: String) {
        this.modelo = modelo;
    }

    public fun getSistema(): String {
        return this.sistemaOperacional
    }

    public fun setSistema(sistema: String) {
        this.sistemaOperacional = sistema;
    }

    public fun getProcessador(): String {
        return this.nomeProcessador;
    }

    public fun setProcessador(processador: String) {
        this.nomeProcessador = processador;
    }

    public fun getCpus(): Int {
        return this.qtdNucleosCpus
    }

    public fun setNucleosCpus(cpus: Int) {
        this.qtdNucleosCpus = cpus;
    }

    public fun getArmazenamento(): Int {
        return this.qtdArmazenamento
    }

    public fun setArmazenamento(armazenamento: Int) {
        this.qtdArmazenamento = armazenamento;
    }

    public fun getDisco(): Int {
        return this.qtdDisco
    }

    public fun setDisco(disco: Int) {
        this.qtdDisco = disco;
    }

    public fun getTeclado(): String {
        var ligado: String = "Desligado";

        if (teclado) {
            ligado = "Ligado";
        }
        return ligado
    }

    public fun setTeclado(teclado: Boolean) {
        this.teclado = teclado
    }

    public fun getMouse(): String {
        var ligado: String = "Desligado";

        if (mouse) {
            ligado = "Ligado";
        }
        return ligado
    }

    public fun setMouse(mouse: Boolean) {
        this.mouse = mouse;
    }

    public fun getLigado(): String {
        var ligad0: String = "Desligado";

        if (ligado) {
            ligad0 = "Ligado";
        }
        return ligad0
    }

    public fun setLigado(ligado: Boolean) {
        this.ligado = ligado;
    }

    public fun getApps(): String{

        var textoApp: String = "";

    for (textoDaVez in listaAplicativos){
        textoApp += "\n ${textoDaVez}";
    }
        return textoApp;
    }

    public fun setApps(app :String){
        this.listaAplicativos.add(app);
    }
}