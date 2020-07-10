
    fun main(args: Array<String>) {
        if (args.size != 2) {
            println("Usage: java Main randomseed1 randomseed2")
            println("Example: java Main 314 15")
            System.exit(0)
        }

        var seed1: Int = args[0].toInt()
        var seed2: Int = args[1].toInt()
        val player1 = Player("Taro", WinningStrategy(seed1))
        val player2 = Player("Hana", ProbStrategy(seed2))

        for (i in 1..1000) {
            val nextHand1 = player1.nextHand()
            val nextHand2 = player2.nextHand()

            if (nextHand1.isStrongerThan(nextHand2)) {
                println("Winner: ${player1.name}");
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                println("Winner: ${player2.name}");
                player1.lose();
                player2.win();
            } else {
                println("Even...");
                player1.even();
                player2.even();
            }
        }
        println("Total result:")
        println("${player1.toStr()}")
        println("${player2.toStr()}")
    }
