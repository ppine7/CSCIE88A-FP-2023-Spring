/** tests for simple app
  */

package com.cscie88a
import org.scalatest.FlatSpec

class FirstSpec extends FlatSpec {
  "An empty set" should "have size 0" in {
    assert(Set.empty.size == 0)
  }

  it should "produce NoSuchElementException for head" in {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }
}
