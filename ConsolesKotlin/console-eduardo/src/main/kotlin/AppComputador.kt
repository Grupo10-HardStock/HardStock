import java.util.Scanner

fun main() {

    val snTexto = Scanner(System.`in`);
    val snNumero = Scanner(System.`in`);

    val computador1 = Computador();

    computador1.setMarca("Dell");
    computador1.setModelo("Inspiron 15");
    computador1.setSistema("Windows");
    computador1.setProcessador("Intel core i5");
    computador1.setNucleosCpus(4);
    computador1.setArmazenamento(16);
    computador1.setDisco(512);
    computador1.setMouse(true);
    computador1.setTeclado(true);
    computador1.setLigado(true);
    computador1.atualizarSistema("Linux");
    computador1.setApps("Vs code");
    computador1.setApps("Calculadora");
    computador1.mostrarApps();
    println("----------------------------------")
    Thread.sleep(1000);

    println(computador1.detalhes())
    println("----------------------------------")

    val computador2 = Computador();

    print("Informe a marca do seu computador: ");
    computador2.setMarca(snTexto.nextLine());

    print("Informe o modelo do seu computador: ");
    computador2.setModelo(snTexto.nextLine());

    print("Informe o sistema operacional: ");
    computador2.setSistema(snTexto.nextLine());

    print("Informe o nome do processador: ");
    computador2.setProcessador(snTexto.nextLine());

    print("Informe a quantidade de núcleos da sua CPU: ");
    computador2.setNucleosCpus(snNumero.nextInt());

    print("Informe a quantidade de Mémoria Ram(GB): ");
    computador2.setArmazenamento(snNumero.nextInt());

    print("Informe a quantidade de armazenamento do disco rígido(GB): ");
    computador2.setDisco(snNumero.nextInt());
    println("----------------------------------")
    println(computador2.detalhes());

    print("Informe a quantidade de armazenamento utilizado(GB): ");
    println("A Quantidade de armazenamento disponível é ${computador2.calcularArmazenamento(snNumero.nextDouble())} GB");
    Thread.sleep(3000);

    computador2.ligar();
    println(computador2.detalhes());
}