public class Hand(handVal: Int) {
    companion object {
        private val HANDVALUE_GUU: Int = 0
        private val HANDVALUE_CHO: Int = 1
        private val HANDVALUE_PAA: Int = 2
        private val hand: Array<Hand> = arrayOf(
            Hand(HANDVALUE_GUU),
            Hand(HANDVALUE_CHO), Hand(HANDVALUE_PAA)
        )
        fun getHand(value: Int) = hand[value]
    }
    private val handValue: Int = handVal
    private val name: Array<String> = arrayOf("グー", "チョキ", "パー")

    private fun fight(h: Hand): Int{
        if(this == h){
            return 0
        } else if((this.handValue + 1) % 3 == h.handValue){
            return 1
        } else {
            return -1
        }
    }
    fun isStrongerThan(h: Hand): Boolean {
        return fight(h) == 1
    }
    fun isWeakerThan(h: Hand):Boolean {
        return fight(h) == -1
    }

    fun toStr():String {
        return name[handValue]
    }

}