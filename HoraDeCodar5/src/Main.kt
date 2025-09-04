//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
        var saldo: Double = 0.0

        println("-----BEM VINDO AO PAGBANCK-----")
        print("Digite seu NOME: ")
        val nome = readln()
        println("Olá $nome, é um prazer ter você por aqui!")

        println()

        var depositos = mutableListOf<Double>()
        var saques = mutableListOf<Double>()

        while (true) {
            println("Digite qual opção deseja de 1 a 5 :")
            println("1-Mostrar Saldo")
            println("2-Extrato")
            println("3-Saque")
            println("4-Deposito")
            println("5-Transferencia")
            println("6-Sair")
            print("OPÇÃO: ")
            val opcao = readln().toIntOrNull()
            if (opcao == null || opcao !in 1..6) {
                println()
                println("❌ Opção inválida! Tente novamente.")
                continue
            }

            when (opcao) {
                1 -> mostrarSaldo(saldo, nome)
                2 -> extrato(depositos, saques)
                3 -> saldo -= saque(saldo, saques, nome)
                4 -> saldo += deposito(depositos)
                5 -> saldo -= trasferencia(saldo, saques, nome)
                6 -> {
                    sair(nome)
                    return
                }
            }
        }
    }

    fun mostrarSaldo(saldo: Double, nome: String) {
        validandoSenha()
        if (saldo <= 0) {
            println("Saldo: R$ 0,00")
        } else {
            println("Saldo atual: R$ %.2f".format(saldo))
        }
    }

    fun extrato(depositos: MutableList<Double>, saques: MutableList<Double>) {
        if (depositos.isEmpty() && saques.isEmpty()) {
            println("VOCÊ AINDA NÃO DEPOSITOU OU SACOU DINHEIRO")
        } else {
            println("=== Extrato ===")
            depositos.forEachIndexed { index, entrada ->
                println("${index + 1}° DEPÓSITO VALOR: R$ %.2f".format(entrada))
            }
            saques.forEachIndexed { index, saida ->
                println("${index + 1}° SAQUE VALOR: R$ %.2f".format(saida))
            }
        }
    }

    fun saque(saldo: Double, sacar: MutableList<Double>, nome: String): Double {
        var valor: Double
        mostrarSaldo(saldo, nome)
        if (saldo <= 0) {
            println("Operação não autorizada: saldo insuficiente")
            return 0.0
        } else {
            while (true) {
                print("Digite o valor que deseja sacar: ")
                valor = readln().toDouble()
                if (valor <= 0) {
                    println("Operação não autorizada: valor deve ser maior que zero")
                } else if (valor > saldo) {
                    println("Operação não autorizada: saldo insuficiente")
                } else {
                    println("Saque realizado com sucesso!")
                    sacar.add(valor)
                    break
                }
            }
        }
        return valor
    }

    fun deposito(transacoes: MutableList<Double>): Double {
        var valor: Double
        do {
            print("Digite o valor do depósito: ")
            valor = readln().toDouble()
            if (valor <= 0) {
                println("Operação não autorizada: valor deve ser maior que zero")
            }
        } while (valor <= 0.0)
        println("Depósito realizado com sucesso!")
        return valor
    }

    fun sair(nome: String) {
        println("$nome, foi um prazer ter você por aqui!")
    }

    fun trasferencia(saldo: Double, sacar: MutableList<Double>, nome: String): Double {
        validandoSenha()
        validandoNuConta()

        var valor: Double
        mostrarSaldo(saldo, nome)
        if (saldo <= 0) {
            println("Operação não autorizada: saldo insuficiente")
            return 0.0
        } else {
            while (true) {
                print("Digite o valor que deseja transferir: ")
                valor = readln().toDouble()
                if (valor <= 0) {
                    println("Operação não autorizada: valor deve ser maior que zero")
                } else if (valor > saldo) {
                    println("Operação não autorizada: saldo insuficiente")
                } else {
                    println("Transferência realizada com sucesso!")
                    sacar.add(valor)
                    break
                }
            }
        }
        return valor
    }

    fun validandoNuConta() {
        var numero: Int
        do {
            try {
                print("Digite seu número da conta: ")
                numero = readln().toInt()
            } catch (e: NumberFormatException) {
                println("❌ Entrada inválida! Digite apenas números positivos.")
                numero = 0
            }
        } while (numero <= 0)
    }

    fun validandoSenha(): Boolean {
        val senha = "3589"
        var valor: String
        var cont = 0

        while (true) {
            print("Digite sua senha: ")
            valor = readln()
            if (senha == valor) {
                println("ACESSO AUTORIZADO")
                break
            } else {
                cont++
                println("SENHA INCORRETA")
                println("$cont DE 3 TENTATIVAS")
            }
            if (cont == 3) {
                println("EXCESSO DE TENTATIVAS! CONTA BLOQUEADA")
                return false
            }
        }
        return true
    }
