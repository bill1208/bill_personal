/**
  * Created by 周生 on 2017/6/11.
  */

package bobscrokets {
  package navigation {
    class Navigator {
      val startMap = new StartMap
      val tes = new Test
    }
    class StartMap
  }
  class Test
  class Ship {
//    val nav = new Navigator //cannot compile, need import or use the package path
    val nav = new navigation.Navigator
  }
}

