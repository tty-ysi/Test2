abstract class Strategy {
    public abstract fun nextHand(): Hand
    public abstract fun study(win:Boolean)
}