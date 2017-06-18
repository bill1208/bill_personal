/**
  * Created by 周生 on 2017/6/11.
  */

package printmenu
import com.scala.chapter13.bobsrockets.navigation.bobsdelights.Fruits
import com.scala.chapter13.bobsrockets.navigation.bobsdelights.showFruit
object PrintMenu {
  def main(args: Array[String]) {
    for(fruit <- Fruits.menu) {
      showFruit(fruit)
    }
  }
}
