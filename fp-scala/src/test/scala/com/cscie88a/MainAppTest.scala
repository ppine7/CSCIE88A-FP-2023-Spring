/** tests for simple app
  */

package com.cscie88a
import com.cscie88a.testutils.{StandardTest}
class FirstSpec extends StandardTest {

"A Set" when {
  "empty" should {
    "have size 0" in {
      Set.empty.size shouldBe 0
    }

    "produce NoSuchElementException when head is invoked" in {
      an [NoSuchElementException] should be thrownBy {
        Set.empty.head
      }
    }
  }
 }}
