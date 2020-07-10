import kotlin.random.Random

class ProbStrategy(seed: Int): Strategy() {
    val random = Random(seed)
    var prevHandValue = 0
    var currentHandValue = 0
    var history = Array(3, {Array(3, { index -> 1})})
    override fun nextHand(): Hand {
        val bet = random.nextInt(getSum(currentHandValue))
        var handvalue = when {
            bet < history[currentHandValue][0] -> {
                0
            }
            bet < history[currentHandValue][0] + history[currentHandValue][1] -> {
                1
            }
            else -> {
                2
            }
        }
        prevHandValue = currentHandValue
        currentHandValue = handvalue
        return Hand.getHand(handvalue)
    }

    private fun getSum(hv:Int): Int{
        var sum = 0
        for(i in 0..2){
            sum += history[hv][i]
        }
        return sum
    }

    override fun study(win: Boolean) {
        if(win){
            history[prevHandValue][currentHandValue]++
        }else{
            history[prevHandValue][(currentHandValue+1)%3]++
            history[prevHandValue][(currentHandValue+2)%3]++
        }
    }
}