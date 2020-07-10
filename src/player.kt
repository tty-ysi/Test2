public class Player (val name:String, val strategy:Strategy){

    private var mName = this.name
    private var mStrategy = this.strategy
    private var wincount:Int = 0
    private var losecount:Int = 0
    private var gamecount:Int = 0

    public fun nextHand(): Hand {
        return mStrategy.nextHand()
    }

    public fun win(){
    mStrategy.study(true)
        wincount++
        gamecount++
    }
    public fun lose() {
        mStrategy.study(false)
        losecount++
        gamecount++
    }
    public fun even() {
        gamecount++
    }

    public fun toStr(): String {
        return "${mName}" +"game:${gamecount}"+"win:${wincount}"+"lose:${losecount}"
    }
}