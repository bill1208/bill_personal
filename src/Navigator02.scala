/**
  * Created by 周生 on 2017/6/11.
  */
package bobsrockets
package navigation {
  private[bobsrockets] class Navigator02 {
    protected[navigation] def useStartChart() = {}
    class LegOfJourney {
      private[Navigator02] val distance = 100
    }
    private[this] var speed = 200
}
}
package launch {
  import navigation._
  object Vehicle {
    private[launch] val guide = new Navigator02
  }

}
